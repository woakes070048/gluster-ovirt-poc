package org.ovirt.engine.core.common.queries;

import org.ovirt.engine.core.compat.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "GetVmsAttachedToAdGroupParameters")
public class GetVmsAttachedToAdGroupParameters extends VdcQueryParametersBase {
    private static final long serialVersionUID = 6577838883414480497L;

    public GetVmsAttachedToAdGroupParameters(Guid id) {
        _id = id;
    }

    // C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to
    // .NET attributes:
    @XmlElement
    private Guid _id = new Guid();

    public Guid getId() {
        return _id;
    }

    public GetVmsAttachedToAdGroupParameters() {
    }
}
