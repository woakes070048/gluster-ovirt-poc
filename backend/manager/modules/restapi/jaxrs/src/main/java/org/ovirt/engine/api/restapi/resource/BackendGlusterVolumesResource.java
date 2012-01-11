/**
 *
 */
package org.ovirt.engine.api.restapi.resource;

import javax.ws.rs.core.Response;

import org.ovirt.engine.api.model.GlusterVolume;
import org.ovirt.engine.api.model.GlusterVolumes;
import org.ovirt.engine.api.resource.GlusterVolumeResource;
import org.ovirt.engine.api.resource.GlusterVolumesResource;
import org.ovirt.engine.core.common.action.VdcActionType;
import org.ovirt.engine.core.common.action.VdcReturnValueBase;
import org.ovirt.engine.core.common.action.VdsGroupParametersBase;
import org.ovirt.engine.core.common.businessentities.GlusterVolumeEntity;
import org.ovirt.engine.core.common.glusteractions.CreateGlusterVolumeParameters;
import org.ovirt.engine.core.compat.Guid;

/**
 *
 */
public class BackendGlusterVolumesResource extends AbstractBackendCollectionResource<GlusterVolume, GlusterVolumeEntity>
        implements GlusterVolumesResource {
    static final String[] SUB_COLLECTIONS = { "bricks", "options" };
    private final String clusterId;

    public BackendGlusterVolumesResource(String clusterId) {
        super(GlusterVolume.class, org.ovirt.engine.core.common.businessentities.GlusterVolumeEntity.class, SUB_COLLECTIONS);
        this.clusterId = clusterId;
    }

    @Override
    public GlusterVolumes list() {
        VdcReturnValueBase result =
                backend.RunAction(VdcActionType.ListGlusterVolumes,
                        new VdsGroupParametersBase(Guid.createGuidFromString(getClusterId())));
        GlusterVolumeEntity[] volumes = (GlusterVolumeEntity[])result.getActionReturnValue();
        return mapCollection(volumes);
    }

    protected GlusterVolumes mapCollection(GlusterVolumeEntity[] entities) {
        GlusterVolumes collection = new GlusterVolumes();
        for (GlusterVolumeEntity entity : entities) {
            collection.getGlusterVolumes().add(populate(map(entity), entity));
        }
        return collection;
    }

    @Override
    @SingleEntityResource
    public GlusterVolumeResource getGlusterVolumeSubResource(String id) {
        return inject(new BackendGlusterVolumeResource(getClusterId(), id, this));
    }

    @Override
    public Response add(GlusterVolume volume) {
        validateParameters(volume, "volumeName", "volumeType", "glusterBricks");

        try {
            GlusterVolumeEntity volumeEntity = getMapper(GlusterVolume.class, GlusterVolumeEntity.class).map(volume, null);
            return performAction(VdcActionType.CreateGlusterVolume,
                    new CreateGlusterVolumeParameters(Guid.createGuidFromString(getClusterId()), volumeEntity));
        } catch (Exception e) {
            return handleError(e, false);
        }
    }

    public String getClusterId() {
        return clusterId;
    }

    @Override
    protected Response performRemove(String id) {
        // TODO Invoke VDSM to remove the volume
        return null;
    }
}
