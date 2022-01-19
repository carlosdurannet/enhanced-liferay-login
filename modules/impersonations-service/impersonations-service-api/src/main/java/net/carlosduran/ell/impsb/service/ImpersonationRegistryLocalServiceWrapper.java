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

package net.carlosduran.ell.impsb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImpersonationRegistryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImpersonationRegistryLocalService
 * @generated
 */
public class ImpersonationRegistryLocalServiceWrapper
	implements ImpersonationRegistryLocalService,
			   ServiceWrapper<ImpersonationRegistryLocalService> {

	public ImpersonationRegistryLocalServiceWrapper(
		ImpersonationRegistryLocalService impersonationRegistryLocalService) {

		_impersonationRegistryLocalService = impersonationRegistryLocalService;
	}

	/**
	 * Adds the impersonation registry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistry the impersonation registry
	 * @return the impersonation registry that was added
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		addImpersonationRegistry(
			net.carlosduran.ell.impsb.model.ImpersonationRegistry
				impersonationRegistry) {

		return _impersonationRegistryLocalService.addImpersonationRegistry(
			impersonationRegistry);
	}

	/**
	 * Creates a new impersonation registry with the primary key. Does not add the impersonation registry to the database.
	 *
	 * @param impersonationRegistryId the primary key for the new impersonation registry
	 * @return the new impersonation registry
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		createImpersonationRegistry(long impersonationRegistryId) {

		return _impersonationRegistryLocalService.createImpersonationRegistry(
			impersonationRegistryId);
	}

	/**
	 * Deletes the impersonation registry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistry the impersonation registry
	 * @return the impersonation registry that was removed
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		deleteImpersonationRegistry(
			net.carlosduran.ell.impsb.model.ImpersonationRegistry
				impersonationRegistry) {

		return _impersonationRegistryLocalService.deleteImpersonationRegistry(
			impersonationRegistry);
	}

	/**
	 * Deletes the impersonation registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry that was removed
	 * @throws PortalException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
			deleteImpersonationRegistry(long impersonationRegistryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _impersonationRegistryLocalService.deleteImpersonationRegistry(
			impersonationRegistryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _impersonationRegistryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _impersonationRegistryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _impersonationRegistryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.carlosduran.ell.impsb.model.impl.ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _impersonationRegistryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.carlosduran.ell.impsb.model.impl.ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _impersonationRegistryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _impersonationRegistryLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _impersonationRegistryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		fetchImpersonationRegistry(long impersonationRegistryId) {

		return _impersonationRegistryLocalService.fetchImpersonationRegistry(
			impersonationRegistryId);
	}

	/**
	 * Returns the impersonation registry with the matching UUID and company.
	 *
	 * @param uuid the impersonation registry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		fetchImpersonationRegistryByUuidAndCompanyId(
			String uuid, long companyId) {

		return _impersonationRegistryLocalService.
			fetchImpersonationRegistryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _impersonationRegistryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the impersonation registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.carlosduran.ell.impsb.model.impl.ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @return the range of impersonation registries
	 */
	@Override
	public java.util.List<net.carlosduran.ell.impsb.model.ImpersonationRegistry>
		getImpersonationRegistries(int start, int end) {

		return _impersonationRegistryLocalService.getImpersonationRegistries(
			start, end);
	}

	/**
	 * Returns the number of impersonation registries.
	 *
	 * @return the number of impersonation registries
	 */
	@Override
	public int getImpersonationRegistriesCount() {
		return _impersonationRegistryLocalService.
			getImpersonationRegistriesCount();
	}

	/**
	 * Returns the impersonation registry with the primary key.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry
	 * @throws PortalException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
			getImpersonationRegistry(long impersonationRegistryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _impersonationRegistryLocalService.getImpersonationRegistry(
			impersonationRegistryId);
	}

	/**
	 * Returns the impersonation registry with the matching UUID and company.
	 *
	 * @param uuid the impersonation registry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching impersonation registry
	 * @throws PortalException if a matching impersonation registry could not be found
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
			getImpersonationRegistryByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _impersonationRegistryLocalService.
			getImpersonationRegistryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _impersonationRegistryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _impersonationRegistryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _impersonationRegistryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the impersonation registry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistry the impersonation registry
	 * @return the impersonation registry that was updated
	 */
	@Override
	public net.carlosduran.ell.impsb.model.ImpersonationRegistry
		updateImpersonationRegistry(
			net.carlosduran.ell.impsb.model.ImpersonationRegistry
				impersonationRegistry) {

		return _impersonationRegistryLocalService.updateImpersonationRegistry(
			impersonationRegistry);
	}

	@Override
	public ImpersonationRegistryLocalService getWrappedService() {
		return _impersonationRegistryLocalService;
	}

	@Override
	public void setWrappedService(
		ImpersonationRegistryLocalService impersonationRegistryLocalService) {

		_impersonationRegistryLocalService = impersonationRegistryLocalService;
	}

	private ImpersonationRegistryLocalService
		_impersonationRegistryLocalService;

}