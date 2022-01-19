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

package net.carlosduran.ell.impsb.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import net.carlosduran.ell.impsb.exception.NoSuchImpersonationRegistryException;
import net.carlosduran.ell.impsb.model.ImpersonationRegistry;

/**
 * The persistence interface for the impersonation registry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImpersonationRegistryUtil
 * @generated
 */
@ProviderType
public interface ImpersonationRegistryPersistence
	extends BasePersistence<ImpersonationRegistry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImpersonationRegistryUtil} to access the impersonation registry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ImpersonationRegistry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the impersonation registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid(String uuid);

	/**
	 * Returns a range of all the impersonation registries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @return the range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the impersonation registries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the impersonation registries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns the impersonation registries before and after the current impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param impersonationRegistryId the primary key of the current impersonation registry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	public ImpersonationRegistry[] findByUuid_PrevAndNext(
			long impersonationRegistryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Removes all the impersonation registries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of impersonation registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching impersonation registries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the impersonation registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the impersonation registries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @return the range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the impersonation registries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the impersonation registries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns the impersonation registries before and after the current impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param impersonationRegistryId the primary key of the current impersonation registry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	public ImpersonationRegistry[] findByUuid_C_PrevAndNext(
			long impersonationRegistryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Removes all the impersonation registries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of impersonation registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching impersonation registries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the impersonation registries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findBycompanyId(
		long companyId);

	/**
	 * Returns a range of all the impersonation registries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @return the range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findBycompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the impersonation registries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findBycompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the impersonation registries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findBycompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry findBycompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Returns the first impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry fetchBycompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns the last impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry findBycompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Returns the last impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	public ImpersonationRegistry fetchBycompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns the impersonation registries before and after the current impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param impersonationRegistryId the primary key of the current impersonation registry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	public ImpersonationRegistry[] findBycompanyId_PrevAndNext(
			long impersonationRegistryId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Removes all the impersonation registries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeBycompanyId(long companyId);

	/**
	 * Returns the number of impersonation registries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching impersonation registries
	 */
	public int countBycompanyId(long companyId);

	/**
	 * Caches the impersonation registry in the entity cache if it is enabled.
	 *
	 * @param impersonationRegistry the impersonation registry
	 */
	public void cacheResult(ImpersonationRegistry impersonationRegistry);

	/**
	 * Caches the impersonation registries in the entity cache if it is enabled.
	 *
	 * @param impersonationRegistries the impersonation registries
	 */
	public void cacheResult(
		java.util.List<ImpersonationRegistry> impersonationRegistries);

	/**
	 * Creates a new impersonation registry with the primary key. Does not add the impersonation registry to the database.
	 *
	 * @param impersonationRegistryId the primary key for the new impersonation registry
	 * @return the new impersonation registry
	 */
	public ImpersonationRegistry create(long impersonationRegistryId);

	/**
	 * Removes the impersonation registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry that was removed
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	public ImpersonationRegistry remove(long impersonationRegistryId)
		throws NoSuchImpersonationRegistryException;

	public ImpersonationRegistry updateImpl(
		ImpersonationRegistry impersonationRegistry);

	/**
	 * Returns the impersonation registry with the primary key or throws a <code>NoSuchImpersonationRegistryException</code> if it could not be found.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	public ImpersonationRegistry findByPrimaryKey(long impersonationRegistryId)
		throws NoSuchImpersonationRegistryException;

	/**
	 * Returns the impersonation registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry, or <code>null</code> if a impersonation registry with the primary key could not be found
	 */
	public ImpersonationRegistry fetchByPrimaryKey(
		long impersonationRegistryId);

	/**
	 * Returns all the impersonation registries.
	 *
	 * @return the impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findAll();

	/**
	 * Returns a range of all the impersonation registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @return the range of impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the impersonation registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the impersonation registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of impersonation registries
	 */
	public java.util.List<ImpersonationRegistry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImpersonationRegistry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the impersonation registries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of impersonation registries.
	 *
	 * @return the number of impersonation registries
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}