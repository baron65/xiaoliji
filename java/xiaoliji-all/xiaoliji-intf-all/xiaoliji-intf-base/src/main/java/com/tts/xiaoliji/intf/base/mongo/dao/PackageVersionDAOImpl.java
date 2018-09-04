package com.tts.xiaoliji.intf.base.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mongodb.BasicDBObject;
import com.tts.xiaoliji.intf.base.dao.PackageVersionDAO;
import com.tts.xiaoliji.intf.base.dto.PackageVersionDTO;

import cn.openlo.dataobject.DAO;
import cn.openlo.nosql.mongo.MongoDaoBase;

//201218.zzh.@Component
public class PackageVersionDAOImpl extends MongoDaoBase<PackageVersionDTO> implements DAO, PackageVersionDAO {
	public void savePackageVersion(PackageVersionDTO dto) {
		super.save(dto);
	}

	public PackageVersionDTO getLatestVersion(String type) {
		PackageVersionDTO result = null;
		Criteria criteria = Criteria.where("valid").is("Y").and("type").is(type);
		List<PackageVersionDTO> qryList = super.find(criteria, "versionNo DESC", 0, 1);
		if (!CollectionUtils.isEmpty(qryList)) {
			result = (PackageVersionDTO) qryList.get(0);
		}
		return result;
	}

	public PackageVersionDTO getSpecifiedVersion(String type, int versionNo) {
		PackageVersionDTO result = null;
		Criteria criteria = Criteria.where("versionNo").is(Integer.valueOf(versionNo)).and("type").is(type);
		result = (PackageVersionDTO) super.findOne(criteria);
		return result;
	}

	public int getLatestVersionNo(String type) {
		int result = 1;
		Criteria criteria = Criteria.where("valid").is("Y").and("type").is(type);
		List<PackageVersionDTO> qryList = super.find(criteria, "versionNo DESC", 0, 1);
		if (!CollectionUtils.isEmpty(qryList)) {
			result = ((PackageVersionDTO) qryList.get(0)).getVersionNo();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<String> qryPackageType() {
		Query query = new Query();
		super.find(query);
		MongoTemplate template = (MongoTemplate) super.getMongoOperations();
		return template.getCollection("packageVersionDTO").distinct("type", new BasicDBObject("valid", "Y"));
	}
}
