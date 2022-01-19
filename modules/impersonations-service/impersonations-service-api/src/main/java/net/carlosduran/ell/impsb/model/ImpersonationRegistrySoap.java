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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImpersonationRegistrySoap implements Serializable {

	public static ImpersonationRegistrySoap toSoapModel(
		ImpersonationRegistry model) {

		ImpersonationRegistrySoap soapModel = new ImpersonationRegistrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setImpersonationRegistryId(
			model.getImpersonationRegistryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setImpersonatedUserId(model.getImpersonatedUserId());
		soapModel.setImpersonatedScreenName(model.getImpersonatedScreenName());
		soapModel.setOperationDate(model.getOperationDate());
		soapModel.setOperationResult(model.getOperationResult());

		return soapModel;
	}

	public static ImpersonationRegistrySoap[] toSoapModels(
		ImpersonationRegistry[] models) {

		ImpersonationRegistrySoap[] soapModels =
			new ImpersonationRegistrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImpersonationRegistrySoap[][] toSoapModels(
		ImpersonationRegistry[][] models) {

		ImpersonationRegistrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ImpersonationRegistrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImpersonationRegistrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImpersonationRegistrySoap[] toSoapModels(
		List<ImpersonationRegistry> models) {

		List<ImpersonationRegistrySoap> soapModels =
			new ArrayList<ImpersonationRegistrySoap>(models.size());

		for (ImpersonationRegistry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ImpersonationRegistrySoap[soapModels.size()]);
	}

	public ImpersonationRegistrySoap() {
	}

	public long getPrimaryKey() {
		return _impersonationRegistryId;
	}

	public void setPrimaryKey(long pk) {
		setImpersonationRegistryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getImpersonationRegistryId() {
		return _impersonationRegistryId;
	}

	public void setImpersonationRegistryId(long impersonationRegistryId) {
		_impersonationRegistryId = impersonationRegistryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public long getImpersonatedUserId() {
		return _impersonatedUserId;
	}

	public void setImpersonatedUserId(long impersonatedUserId) {
		_impersonatedUserId = impersonatedUserId;
	}

	public String getImpersonatedScreenName() {
		return _impersonatedScreenName;
	}

	public void setImpersonatedScreenName(String impersonatedScreenName) {
		_impersonatedScreenName = impersonatedScreenName;
	}

	public Date getOperationDate() {
		return _operationDate;
	}

	public void setOperationDate(Date operationDate) {
		_operationDate = operationDate;
	}

	public int getOperationResult() {
		return _operationResult;
	}

	public void setOperationResult(int operationResult) {
		_operationResult = operationResult;
	}

	private String _uuid;
	private long _impersonationRegistryId;
	private long _companyId;
	private long _userId;
	private String _screenName;
	private long _impersonatedUserId;
	private String _impersonatedScreenName;
	private Date _operationDate;
	private int _operationResult;

}