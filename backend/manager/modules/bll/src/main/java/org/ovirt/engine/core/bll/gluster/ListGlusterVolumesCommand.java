/**
 *
 */
package org.ovirt.engine.core.bll.gluster;

import java.util.Collections;
import java.util.Map;

import org.ovirt.engine.core.common.VdcObjectType;
import org.ovirt.engine.core.common.action.CreateGlusterVolumeParameters;
import org.ovirt.engine.core.common.action.VdsGroupParametersBase;
import org.ovirt.engine.core.common.vdscommands.VDSReturnValue;
import org.ovirt.engine.core.dal.VdcBllMessages;

/**
 *
 */
public class ListGlusterVolumesCommand extends GlusterCommandBase<VdsGroupParametersBase> {

    public ListGlusterVolumesCommand(CreateGlusterVolumeParameters params) {
        super(params);
    }

    @Override
    protected boolean canDoAction() {
        boolean canDoAction = super.canDoAction();
        if(!canDoAction) {
            addCanDoActionMessage(VdcBllMessages.VAR__ACTION__LIST);
        }
        return canDoAction;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.ovirt.engine.core.bll.CommandBase#executeCommand()
     */
    @Override
    protected void executeCommand() {
        //TODO: Introduce a new VDS command for listGlusterVolumes and invoke it
        VDSReturnValue returnValue = null;
//                Backend
//                        .getInstance()
//                        .getResourceManager()
//                        .RunVdsCommand(
//                                VDSCommandType.CreateGlusterVolume,
//                                new CreateGlusterVolumeVDSParameters(getVdsGroup().getstorage_pool_id().getValue(),
//                                        getParameters().getVolume()));
        setSucceeded(returnValue.getSucceeded());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.ovirt.engine.core.bll.CommandBase#getPermissionCheckSubjects()
     */
    @Override
    public Map getPermissionCheckSubjects() {
        return Collections.singletonMap(getVdsGroupId(), VdcObjectType.VdsGroups);
    }
}
