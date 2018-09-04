package com.tts.xiaoliji.intf.base.dao;

import java.util.List;

import com.tts.xiaoliji.intf.base.dto.PackageVersionDTO;

public abstract interface PackageVersionDAO {
	public abstract void savePackageVersion(PackageVersionDTO paramPackageVersionDTO);

	public abstract PackageVersionDTO getLatestVersion(String paramString);

	public abstract PackageVersionDTO getSpecifiedVersion(String paramString, int paramInt);

	public abstract int getLatestVersionNo(String paramString);

	public abstract List<String> qryPackageType();
}
