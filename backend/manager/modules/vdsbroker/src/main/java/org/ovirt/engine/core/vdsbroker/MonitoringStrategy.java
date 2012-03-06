package org.ovirt.engine.core.vdsbroker;

import org.ovirt.engine.core.common.businessentities.VDS;

/**
 * This interface defines service strategy entry points, which are needed in host monitoring phase
 */
public interface MonitoringStrategy {
    /**
     * Check VDS hardware capabilities, and update VDS accordingly
     */
    public void processHardwareCapabilities(VDS vds);

    /**
     * Checking for the existence of special software capabilities, and update VDS accordingly
     */
    public void processSoftwareCapabilities(VDS vds);

    /**
     * Can this VDS go to maintenance now?
     */
    public boolean canMoveToMaintenance(VDS vds);

    /**
     * Do we need to monitor this VDS?
     */
    public boolean isMonitoringNeeded(VDS vds);

}