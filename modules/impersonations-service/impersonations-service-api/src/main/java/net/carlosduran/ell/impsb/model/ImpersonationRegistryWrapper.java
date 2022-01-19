/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.carlosduran.ell.impsb.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ImpersonationRegistry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpersonationRegistry
 * @generated
 */
public class ImpersonationRegistryWrapper
	implements ImpersonationRegistry, ModelWrapper<ImpersonationRegistry> {

	public ImpersonationRegistryWrapper(
		ImpersonationRegistry impersonationRegistry) {

		_impersonationRegistry = impersonationRegistry;
	}

	@Override
	public Class<?> getModelClass() {
		return ImpersonationRegistry.class;
	}

	@Override
	public String getModelClassName() {
		return ImpersonationRegistry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("impersonationRegistryId", getImpersonationRegistryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("screenName", getScreenName());
		attributes.put("impersonatedUserId", getImpersonatedUserId());
		attributes.put("impersonatedScreenName", getImpersonatedScreenName());
		attributes.put("operationDate", getOperationDate());
		attributes.put("operationResult", getOperationResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long impersonationRegistryId = (Long)attributes.get(
			"impersonationRegistryId");

		if (impersonationRegistryId != null) {
			setImpersonationRegistryId(impersonationRegistryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		Long impersonatedUserId = (Long)attributes.get("impersonatedUserId");

		if (impersonatedUserId != null) {
			setImpersonatedUserId(impersonatedUserId);
		}

		String impersonatedScreenName = (String)attributes.get(
			"impersonatedScreenName");

		if (impersonatedScreenName != null) {
			setImpersonatedScreenName(impersonatedScreenName);
		}

		Date operationDate = (Date)attributes.get("operationDate");

		if (operationDate != null) {
			setOperationDate(operationDate);
		}

		Integer operationResult = (Integer)attributes.get("operationResult");

		if (operationResult != null) {
			setOperationResult(operationResult);
		}
	}

	@Override
	public Object clone() {
		return new ImpersonationRegistryWrapper(
			(ImpersonationRegistry)_impersonationRegistry.clone());
	}

	@Override
	public int compareTo(
		net.carlosduran.ell.impsb.model.ImpersonationRegistry
			impersonationRegistry) {

		return _impersonationRegistry.compareTo(impersonationRegistry);
	}

	/**
	 * Returns the company ID of this impersonation registry.
	 *
	 * @return the company ID of this impersonation registry
	 */
	@Override
	public long getCompanyId() {
		return _impersonationRegistry.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _impersonationRegistry.getExpandoBridge();
	}

	/**
	 * Returns the impersonated screen name of this impersonation registry.
	 *
	 * @return the impersonated screen name of this impersonation registry
	 */
	@Override
	public String getImpersonatedScreenName() {
		return _impersonationRegistry.getImpersonatedScreenName();
	}

	/**
	 * Returns the impersonated user ID of this impersonation registry.
	 *
	 * @return the impersonated user ID of this impersonation registry
	 */
	@Override
	public long getImpersonatedUserId() {
		return _impersonationRegistry.getImpersonatedUserId();
	}

	/**
	 * Returns the impersonated user uuid of this impersonation registry.
	 *
	 * @return the impersonated user uuid of this impersonation registry
	 */
	@Override
	public String getImpersonatedUserUuid() {
		return _impersonationRegistry.getImpersonatedUserUuid();
	}

	/**
	 * Returns the impersonation registry ID of this impersonation registry.
	 *
	 * @return the impersonation registry ID of this impersonation registry
	 */
	@Override
	public long getImpersonationRegistryId() {
		return _impersonationRegistry.getImpersonationRegistryId();
	}

	/**
	 * Returns the operation date of this impersonation registry.
	 *
	 * @return the operation date of this impersonation registry
	 */
	@Override
	public Date getOperationDate() {
		return _impersonationRegistry.getOperationDate();
	}

	/**
	 * Returns the operation result of this impersonation registry.
	 *
	 * @return the operation result of this impersonation registry
	 */
	@Override
	public int getOperationResult() {
		return _impersonationRegistry.getOperationResult();
	}

	/**
	 * Returns the primary key of this impersonation registry.
	 *
	 * @return the primary key of this impersonation registry
	 */
	@Override
	public long getPrimaryKey() {
		return _impersonationRegistry.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _impersonationRegistry.getPrimaryKeyObj();
	}

	/**
	 * Returns the screen name of this impersonation registry.
	 *
	 * @return the screen name of this impersonation registry
	 */
	@Override
	public String getScreenName() {
		return _impersonationRegistry.getScreenName();
	}

	/**
	 * Returns the user ID of this impersonation registry.
	 *
	 * @return the user ID of this impersonation registry
	 */
	@Override
	public long getUserId() {
		return _impersonationRegistry.getUserId();
	}

	/**
	 * Returns the user uuid of this impersonation registry.
	 *
	 * @return the user uuid of this impersonation registry
	 */
	@Override
	public String getUserUuid() {
		return _impersonationRegistry.getUserUuid();
	}

	/**
	 * Returns the uuid of this impersonation registry.
	 *
	 * @return the uuid of this impersonation registry
	 */
	@Override
	public String getUuid() {
		return _impersonationRegistry.getUuid();
	}

	@Override
	public int hashCode() {
		return _impersonationRegistry.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _impersonationRegistry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _impersonationRegistry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _impersonationRegistry.isNew();
	}

	@Override
	public void persist() {
		_impersonationRegistry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_impersonationRegistry.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this impersonation registry.
	 *
	 * @param companyId the company ID of this impersonation registry
	 */
	@Override
	public void setCompanyId(long companyId) {
		_impersonationRegistry.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_impersonationRegistry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_impersonationRegistry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_impersonationRegistry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the impersonated screen name of this impersonation registry.
	 *
	 * @param impersonatedScreenName the impersonated screen name of this impersonation registry
	 */
	@Override
	public void setImpersonatedScreenName(String impersonatedScreenName) {
		_impersonationRegistry.setImpersonatedScreenName(
			impersonatedScreenName);
	}

	/**
	 * Sets the impersonated user ID of this impersonation registry.
	 *
	 * @param impersonatedUserId the impersonated user ID of this impersonation registry
	 */
	@Override
	public void setImpersonatedUserId(long impersonatedUserId) {
		_impersonationRegistry.setImpersonatedUserId(impersonatedUserId);
	}

	/**
	 * Sets the impersonated user uuid of this impersonation registry.
	 *
	 * @param impersonatedUserUuid the impersonated user uuid of this impersonation registry
	 */
	@Override
	public void setImpersonatedUserUuid(String impersonatedUserUuid) {
		_impersonationRegistry.setImpersonatedUserUuid(impersonatedUserUuid);
	}

	/**
	 * Sets the impersonation registry ID of this impersonation registry.
	 *
	 * @param impersonationRegistryId the impersonation registry ID of this impersonation registry
	 */
	@Override
	public void setImpersonationRegistryId(long impersonationRegistryId) {
		_impersonationRegistry.setImpersonationRegistryId(
			impersonationRegistryId);
	}

	@Override
	public void setNew(boolean n) {
		_impersonationRegistry.setNew(n);
	}

	/**
	 * Sets the operation date of this impersonation registry.
	 *
	 * @param operationDate the operation date of this impersonation registry
	 */
	@Override
	public void setOperationDate(Date operationDate) {
		_impersonationRegistry.setOperationDate(operationDate);
	}

	/**
	 * Sets the operation result of this impersonation registry.
	 *
	 * @param operationResult the operation result of this impersonation registry
	 */
	@Override
	public void setOperationResult(int operationResult) {
		_impersonationRegistry.setOperationResult(operationResult);
	}

	/**
	 * Sets the primary key of this impersonation registry.
	 *
	 * @param primaryKey the primary key of this impersonation registry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_impersonationRegistry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_impersonationRegistry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the screen name of this impersonation registry.
	 *
	 * @param screenName the screen name of this impersonation registry
	 */
	@Override
	public void setScreenName(String screenName) {
		_impersonationRegistry.setScreenName(screenName);
	}

	/**
	 * Sets the user ID of this impersonation registry.
	 *
	 * @param userId the user ID of this impersonation registry
	 */
	@Override
	public void setUserId(long userId) {
		_impersonationRegistry.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this impersonation registry.
	 *
	 * @param userUuid the user uuid of this impersonation registry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_impersonationRegistry.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this impersonation registry.
	 *
	 * @param uuid the uuid of this impersonation registry
	 */
	@Override
	public void setUuid(String uuid) {
		_impersonationRegistry.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<net.carlosduran.ell.impsb.model.ImpersonationRegistry> toCacheModel() {

		return _impersonationRegistry.toCacheModel();
	}

	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		toEscapedModel() {

		return new ImpersonationRegistryWrapper(
			_impersonationRegistry.toEscapedModel());
	}

	@Override
	public String toString() {
		return _impersonationRegistry.toString();
	}

	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		toUnescapedModel() {

		return new ImpersonationRegistryWrapper(
			_impersonationRegistry.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _impersonationRegistry.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImpersonationRegistryWrapper)) {
			return false;
		}

		ImpersonationRegistryWrapper impersonationRegistryWrapper =
			(ImpersonationRegistryWrapper)object;

		if (Objects.equals(
				_impersonationRegistry,
				impersonationRegistryWrapper._impersonationRegistry)) {

			return true;
		}

		return false;
	}

	@Override
	public ImpersonationRegistry getWrappedModel() {
		return _impersonationRegistry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _impersonationRegistry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _impersonationRegistry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_impersonationRegistry.resetOriginalValues();
	}

	private final ImpersonationRegistry _impersonationRegistry;

}