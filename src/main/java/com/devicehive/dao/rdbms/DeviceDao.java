package com.devicehive.dao.rdbms;

import com.devicehive.auth.HivePrincipal;
import com.devicehive.model.Device;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Gleb on 07.07.2016.
 */
public interface DeviceDao {

    Device findByUUID(String uuid);

    void persist(Device device);

    int deleteByUUID(String guid);

    List<Device> getDeviceList(List<String> guids, HivePrincipal principal);

    long getAllowedDeviceCount(HivePrincipal principal, List<String> guids);

    List<Device> getList(String name, String namePattern, String status, Long networkId, String networkName,
                         Long deviceClassId, String deviceClassName, String deviceClassVersion, String sortField,
                         @NotNull Boolean sortOrderAsc, Integer take, Integer skip, HivePrincipal principal);

}
