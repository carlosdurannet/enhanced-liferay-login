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

package net.carlosduran.ell.impsb.model.impl;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import net.carlosduran.ell.impsb.model.ImpersonationRegistry;

/**
 * The cache model class for representing ImpersonationRegistry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImpersonationRegistryCacheModel
	implements CacheModel<ImpersonationRegistry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImpersonationRegistryCacheModel)) {
			return false;
		}

		ImpersonationRegistryCacheModel impersonationRegistryCacheModel =
			(ImpersonationRegistryCacheModel)object;

		if (impersonationRegistryId ==
				impersonationRegistryCacheModel.impersonationRegistryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, impersonationRegistryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", impersonationRegistryId=");
		sb.append(impersonationRegistryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", impersonatedUserId=");
		sb.append(impersonatedUserId);
		sb.append(", impersonatedScreenName=");
		sb.append(impersonatedScreenName);
		sb.append(", operationDate=");
		sb.append(operationDate);
		sb.append(", operationResult=");
		sb.append(operationResult);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImpersonationRegistry toEntityModel() {
		ImpersonationRegistryImpl impersonationRegistryImpl =
			new ImpersonationRegistryImpl();

		if (uuid == null) {
			impersonationRegistryImpl.setUuid("");
		}
		else {
			impersonationRegistryImpl.setUuid(uuid);
		}

		impersonationRegistryImpl.setImpersonationRegistryId(
			impersonationRegistryId);
		impersonationRegistryImpl.setCompanyId(companyId);
		impersonationRegistryImpl.setUserId(userId);

		if (screenName == null) {
			impersonationRegistryImpl.setScreenName("");
		}
		else {
			impersonationRegistryImpl.setScreenName(screenName);
		}

		impersonationRegistryImpl.setImpersonatedUserId(impersonatedUserId);

		if (impersonatedScreenName == null) {
			impersonationRegistryImpl.setImpersonatedScreenName("");
		}
		else {
			impersonationRegistryImpl.setImpersonatedScreenName(
				impersonatedScreenName);
		}

		if (operationDate == Long.MIN_VALUE) {
			impersonationRegistryImpl.setOperationDate(null);
		}
		else {
			impersonationRegistryImpl.setOperationDate(new Date(operationDate));
		}

		impersonationRegistryImpl.setOperationResult(operationResult);

		impersonationRegistryImpl.resetOriginalValues();

		return impersonationRegistryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		impersonationRegistryId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		screenName = objectInput.readUTF();

		impersonatedUserId = objectInput.readLong();
		impersonatedScreenName = objectInput.readUTF();
		operationDate = objectInput.readLong();

		operationResult = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(impersonationRegistryId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (screenName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		objectOutput.writeLong(impersonatedUserId);

		if (impersonatedScreenName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(impersonatedScreenName);
		}

		objectOutput.writeLong(operationDate);

		objectOutput.writeInt(operationResult);
	}

	public String uuid;
	public long impersonationRegistryId;
	public long companyId;
	public long userId;
	public String screenName;
	public long impersonatedUserId;
	public String impersonatedScreenName;
	public long operationDate;
	public int operationResult;

}