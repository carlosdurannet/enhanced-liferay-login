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

package net.carlosduran.ell.impsb.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import net.carlosduran.ell.impsb.exception.NoSuchImpersonationRegistryException;
import net.carlosduran.ell.impsb.model.ImpersonationRegistry;
import net.carlosduran.ell.impsb.model.impl.ImpersonationRegistryImpl;
import net.carlosduran.ell.impsb.model.impl.ImpersonationRegistryModelImpl;
import net.carlosduran.ell.impsb.service.persistence.ImpersonationRegistryPersistence;
import net.carlosduran.ell.impsb.service.persistence.ImpersonationRegistryUtil;

/**
 * The persistence implementation for the impersonation registry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImpersonationRegistryPersistenceImpl
	extends BasePersistenceImpl<ImpersonationRegistry>
	implements ImpersonationRegistryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImpersonationRegistryUtil</code> to access the impersonation registry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImpersonationRegistryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the impersonation registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching impersonation registries
	 */
	@Override
	public List<ImpersonationRegistry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ImpersonationRegistry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ImpersonationRegistry> list = null;

		if (useFinderCache) {
			list = (List<ImpersonationRegistry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImpersonationRegistry impersonationRegistry : list) {
					if (!uuid.equals(impersonationRegistry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImpersonationRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ImpersonationRegistry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry findByUuid_First(
			String uuid,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = fetchByUuid_First(
			uuid, orderByComparator);

		if (impersonationRegistry != null) {
			return impersonationRegistry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchImpersonationRegistryException(sb.toString());
	}

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry fetchByUuid_First(
		String uuid,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		List<ImpersonationRegistry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry findByUuid_Last(
			String uuid,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (impersonationRegistry != null) {
			return impersonationRegistry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchImpersonationRegistryException(sb.toString());
	}

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry fetchByUuid_Last(
		String uuid,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ImpersonationRegistry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the impersonation registries before and after the current impersonation registry in the ordered set where uuid = &#63;.
	 *
	 * @param impersonationRegistryId the primary key of the current impersonation registry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry[] findByUuid_PrevAndNext(
			long impersonationRegistryId, String uuid,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		uuid = Objects.toString(uuid, "");

		ImpersonationRegistry impersonationRegistry = findByPrimaryKey(
			impersonationRegistryId);

		Session session = null;

		try {
			session = openSession();

			ImpersonationRegistry[] array = new ImpersonationRegistryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, impersonationRegistry, uuid, orderByComparator, true);

			array[1] = impersonationRegistry;

			array[2] = getByUuid_PrevAndNext(
				session, impersonationRegistry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImpersonationRegistry getByUuid_PrevAndNext(
		Session session, ImpersonationRegistry impersonationRegistry,
		String uuid, OrderByComparator<ImpersonationRegistry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ImpersonationRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						impersonationRegistry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ImpersonationRegistry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the impersonation registries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ImpersonationRegistry impersonationRegistry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(impersonationRegistry);
		}
	}

	/**
	 * Returns the number of impersonation registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching impersonation registries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMPERSONATIONREGISTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"impersonationRegistry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(impersonationRegistry.uuid IS NULL OR impersonationRegistry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the impersonation registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching impersonation registries
	 */
	@Override
	public List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ImpersonationRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ImpersonationRegistry> list = null;

		if (useFinderCache) {
			list = (List<ImpersonationRegistry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImpersonationRegistry impersonationRegistry : list) {
					if (!uuid.equals(impersonationRegistry.getUuid()) ||
						(companyId != impersonationRegistry.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImpersonationRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ImpersonationRegistry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (impersonationRegistry != null) {
			return impersonationRegistry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchImpersonationRegistryException(sb.toString());
	}

	/**
	 * Returns the first impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		List<ImpersonationRegistry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (impersonationRegistry != null) {
			return impersonationRegistry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchImpersonationRegistryException(sb.toString());
	}

	/**
	 * Returns the last impersonation registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ImpersonationRegistry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ImpersonationRegistry[] findByUuid_C_PrevAndNext(
			long impersonationRegistryId, String uuid, long companyId,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		uuid = Objects.toString(uuid, "");

		ImpersonationRegistry impersonationRegistry = findByPrimaryKey(
			impersonationRegistryId);

		Session session = null;

		try {
			session = openSession();

			ImpersonationRegistry[] array = new ImpersonationRegistryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, impersonationRegistry, uuid, companyId,
				orderByComparator, true);

			array[1] = impersonationRegistry;

			array[2] = getByUuid_C_PrevAndNext(
				session, impersonationRegistry, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImpersonationRegistry getByUuid_C_PrevAndNext(
		Session session, ImpersonationRegistry impersonationRegistry,
		String uuid, long companyId,
		OrderByComparator<ImpersonationRegistry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ImpersonationRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						impersonationRegistry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ImpersonationRegistry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the impersonation registries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ImpersonationRegistry impersonationRegistry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(impersonationRegistry);
		}
	}

	/**
	 * Returns the number of impersonation registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching impersonation registries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IMPERSONATIONREGISTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"impersonationRegistry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(impersonationRegistry.uuid IS NULL OR impersonationRegistry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"impersonationRegistry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBycompanyId;
	private FinderPath _finderPathWithoutPaginationFindBycompanyId;
	private FinderPath _finderPathCountBycompanyId;

	/**
	 * Returns all the impersonation registries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching impersonation registries
	 */
	@Override
	public List<ImpersonationRegistry> findBycompanyId(long companyId) {
		return findBycompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findBycompanyId(
		long companyId, int start, int end) {

		return findBycompanyId(companyId, start, end, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findBycompanyId(
		long companyId, int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		return findBycompanyId(companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ImpersonationRegistry> findBycompanyId(
		long companyId, int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<ImpersonationRegistry> list = null;

		if (useFinderCache) {
			list = (List<ImpersonationRegistry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImpersonationRegistry impersonationRegistry : list) {
					if (companyId != impersonationRegistry.getCompanyId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImpersonationRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<ImpersonationRegistry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry findBycompanyId_First(
			long companyId,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = fetchBycompanyId_First(
			companyId, orderByComparator);

		if (impersonationRegistry != null) {
			return impersonationRegistry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchImpersonationRegistryException(sb.toString());
	}

	/**
	 * Returns the first impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry fetchBycompanyId_First(
		long companyId,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		List<ImpersonationRegistry> list = findBycompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry findBycompanyId_Last(
			long companyId,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = fetchBycompanyId_Last(
			companyId, orderByComparator);

		if (impersonationRegistry != null) {
			return impersonationRegistry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchImpersonationRegistryException(sb.toString());
	}

	/**
	 * Returns the last impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry fetchBycompanyId_Last(
		long companyId,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		int count = countBycompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<ImpersonationRegistry> list = findBycompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the impersonation registries before and after the current impersonation registry in the ordered set where companyId = &#63;.
	 *
	 * @param impersonationRegistryId the primary key of the current impersonation registry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry[] findBycompanyId_PrevAndNext(
			long impersonationRegistryId, long companyId,
			OrderByComparator<ImpersonationRegistry> orderByComparator)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = findByPrimaryKey(
			impersonationRegistryId);

		Session session = null;

		try {
			session = openSession();

			ImpersonationRegistry[] array = new ImpersonationRegistryImpl[3];

			array[0] = getBycompanyId_PrevAndNext(
				session, impersonationRegistry, companyId, orderByComparator,
				true);

			array[1] = impersonationRegistry;

			array[2] = getBycompanyId_PrevAndNext(
				session, impersonationRegistry, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImpersonationRegistry getBycompanyId_PrevAndNext(
		Session session, ImpersonationRegistry impersonationRegistry,
		long companyId,
		OrderByComparator<ImpersonationRegistry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ImpersonationRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						impersonationRegistry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ImpersonationRegistry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the impersonation registries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeBycompanyId(long companyId) {
		for (ImpersonationRegistry impersonationRegistry :
				findBycompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(impersonationRegistry);
		}
	}

	/**
	 * Returns the number of impersonation registries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching impersonation registries
	 */
	@Override
	public int countBycompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountBycompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMPERSONATIONREGISTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"impersonationRegistry.companyId = ?";

	public ImpersonationRegistryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(ImpersonationRegistry.class);
	}

	/**
	 * Caches the impersonation registry in the entity cache if it is enabled.
	 *
	 * @param impersonationRegistry the impersonation registry
	 */
	@Override
	public void cacheResult(ImpersonationRegistry impersonationRegistry) {
		entityCache.putResult(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			impersonationRegistry.getPrimaryKey(), impersonationRegistry);

		impersonationRegistry.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the impersonation registries in the entity cache if it is enabled.
	 *
	 * @param impersonationRegistries the impersonation registries
	 */
	@Override
	public void cacheResult(
		List<ImpersonationRegistry> impersonationRegistries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (impersonationRegistries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ImpersonationRegistry impersonationRegistry :
				impersonationRegistries) {

			if (entityCache.getResult(
					ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
					ImpersonationRegistryImpl.class,
					impersonationRegistry.getPrimaryKey()) == null) {

				cacheResult(impersonationRegistry);
			}
			else {
				impersonationRegistry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all impersonation registries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImpersonationRegistryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the impersonation registry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImpersonationRegistry impersonationRegistry) {
		entityCache.removeResult(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			impersonationRegistry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ImpersonationRegistry> impersonationRegistries) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImpersonationRegistry impersonationRegistry :
				impersonationRegistries) {

			entityCache.removeResult(
				ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
				ImpersonationRegistryImpl.class,
				impersonationRegistry.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
				ImpersonationRegistryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new impersonation registry with the primary key. Does not add the impersonation registry to the database.
	 *
	 * @param impersonationRegistryId the primary key for the new impersonation registry
	 * @return the new impersonation registry
	 */
	@Override
	public ImpersonationRegistry create(long impersonationRegistryId) {
		ImpersonationRegistry impersonationRegistry =
			new ImpersonationRegistryImpl();

		impersonationRegistry.setNew(true);
		impersonationRegistry.setPrimaryKey(impersonationRegistryId);

		String uuid = PortalUUIDUtil.generate();

		impersonationRegistry.setUuid(uuid);

		impersonationRegistry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return impersonationRegistry;
	}

	/**
	 * Removes the impersonation registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry that was removed
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry remove(long impersonationRegistryId)
		throws NoSuchImpersonationRegistryException {

		return remove((Serializable)impersonationRegistryId);
	}

	/**
	 * Removes the impersonation registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the impersonation registry
	 * @return the impersonation registry that was removed
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry remove(Serializable primaryKey)
		throws NoSuchImpersonationRegistryException {

		Session session = null;

		try {
			session = openSession();

			ImpersonationRegistry impersonationRegistry =
				(ImpersonationRegistry)session.get(
					ImpersonationRegistryImpl.class, primaryKey);

			if (impersonationRegistry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImpersonationRegistryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(impersonationRegistry);
		}
		catch (NoSuchImpersonationRegistryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ImpersonationRegistry removeImpl(
		ImpersonationRegistry impersonationRegistry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(impersonationRegistry)) {
				impersonationRegistry = (ImpersonationRegistry)session.get(
					ImpersonationRegistryImpl.class,
					impersonationRegistry.getPrimaryKeyObj());
			}

			if (impersonationRegistry != null) {
				session.delete(impersonationRegistry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (impersonationRegistry != null) {
			clearCache(impersonationRegistry);
		}

		return impersonationRegistry;
	}

	@Override
	public ImpersonationRegistry updateImpl(
		ImpersonationRegistry impersonationRegistry) {

		boolean isNew = impersonationRegistry.isNew();

		if (!(impersonationRegistry instanceof
				ImpersonationRegistryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(impersonationRegistry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					impersonationRegistry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in impersonationRegistry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ImpersonationRegistry implementation " +
					impersonationRegistry.getClass());
		}

		ImpersonationRegistryModelImpl impersonationRegistryModelImpl =
			(ImpersonationRegistryModelImpl)impersonationRegistry;

		if (Validator.isNull(impersonationRegistry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			impersonationRegistry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(impersonationRegistry);

				impersonationRegistry.setNew(false);
			}
			else {
				impersonationRegistry = (ImpersonationRegistry)session.merge(
					impersonationRegistry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ImpersonationRegistryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				impersonationRegistryModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				impersonationRegistryModelImpl.getUuid(),
				impersonationRegistryModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {impersonationRegistryModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountBycompanyId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBycompanyId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((impersonationRegistryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					impersonationRegistryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {impersonationRegistryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((impersonationRegistryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					impersonationRegistryModelImpl.getOriginalUuid(),
					impersonationRegistryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					impersonationRegistryModelImpl.getUuid(),
					impersonationRegistryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((impersonationRegistryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBycompanyId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					impersonationRegistryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountBycompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBycompanyId, args);

				args = new Object[] {
					impersonationRegistryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountBycompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBycompanyId, args);
			}
		}

		entityCache.putResult(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			impersonationRegistry.getPrimaryKey(), impersonationRegistry,
			false);

		impersonationRegistry.resetOriginalValues();

		return impersonationRegistry;
	}

	/**
	 * Returns the impersonation registry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the impersonation registry
	 * @return the impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImpersonationRegistryException {

		ImpersonationRegistry impersonationRegistry = fetchByPrimaryKey(
			primaryKey);

		if (impersonationRegistry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImpersonationRegistryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return impersonationRegistry;
	}

	/**
	 * Returns the impersonation registry with the primary key or throws a <code>NoSuchImpersonationRegistryException</code> if it could not be found.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry
	 * @throws NoSuchImpersonationRegistryException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry findByPrimaryKey(long impersonationRegistryId)
		throws NoSuchImpersonationRegistryException {

		return findByPrimaryKey((Serializable)impersonationRegistryId);
	}

	/**
	 * Returns the impersonation registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the impersonation registry
	 * @return the impersonation registry, or <code>null</code> if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ImpersonationRegistry impersonationRegistry =
			(ImpersonationRegistry)serializable;

		if (impersonationRegistry == null) {
			Session session = null;

			try {
				session = openSession();

				impersonationRegistry = (ImpersonationRegistry)session.get(
					ImpersonationRegistryImpl.class, primaryKey);

				if (impersonationRegistry != null) {
					cacheResult(impersonationRegistry);
				}
				else {
					entityCache.putResult(
						ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
						ImpersonationRegistryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
					ImpersonationRegistryImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return impersonationRegistry;
	}

	/**
	 * Returns the impersonation registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry, or <code>null</code> if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry fetchByPrimaryKey(
		long impersonationRegistryId) {

		return fetchByPrimaryKey((Serializable)impersonationRegistryId);
	}

	@Override
	public Map<Serializable, ImpersonationRegistry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ImpersonationRegistry> map =
			new HashMap<Serializable, ImpersonationRegistry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ImpersonationRegistry impersonationRegistry = fetchByPrimaryKey(
				primaryKey);

			if (impersonationRegistry != null) {
				map.put(primaryKey, impersonationRegistry);
			}

			return map;
		}

		if ((databaseInMaxParameters > 0) &&
			(primaryKeys.size() > databaseInMaxParameters)) {

			Iterator<Serializable> iterator = primaryKeys.iterator();

			while (iterator.hasNext()) {
				Set<Serializable> page = new HashSet<>();

				for (int i = 0;
					 (i < databaseInMaxParameters) && iterator.hasNext(); i++) {

					page.add(iterator.next());
				}

				map.putAll(fetchByPrimaryKeys(page));
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
				ImpersonationRegistryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ImpersonationRegistry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (ImpersonationRegistry impersonationRegistry :
					(List<ImpersonationRegistry>)query.list()) {

				map.put(
					impersonationRegistry.getPrimaryKeyObj(),
					impersonationRegistry);

				cacheResult(impersonationRegistry);

				uncachedPrimaryKeys.remove(
					impersonationRegistry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
					ImpersonationRegistryImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the impersonation registries.
	 *
	 * @return the impersonation registries
	 */
	@Override
	public List<ImpersonationRegistry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ImpersonationRegistry> findAll(
		int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ImpersonationRegistry> findAll(
		int start, int end,
		OrderByComparator<ImpersonationRegistry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ImpersonationRegistry> list = null;

		if (useFinderCache) {
			list = (List<ImpersonationRegistry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IMPERSONATIONREGISTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IMPERSONATIONREGISTRY;

				sql = sql.concat(ImpersonationRegistryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ImpersonationRegistry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the impersonation registries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImpersonationRegistry impersonationRegistry : findAll()) {
			remove(impersonationRegistry);
		}
	}

	/**
	 * Returns the number of impersonation registries.
	 *
	 * @return the number of impersonation registries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_IMPERSONATIONREGISTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ImpersonationRegistryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the impersonation registry persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ImpersonationRegistryModelImpl.UUID_COLUMN_BITMASK |
			ImpersonationRegistryModelImpl.OPERATIONDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			ImpersonationRegistryModelImpl.UUID_COLUMN_BITMASK |
			ImpersonationRegistryModelImpl.COMPANYID_COLUMN_BITMASK |
			ImpersonationRegistryModelImpl.OPERATIONDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindBycompanyId = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBycompanyId = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED,
			ImpersonationRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycompanyId",
			new String[] {Long.class.getName()},
			ImpersonationRegistryModelImpl.COMPANYID_COLUMN_BITMASK |
			ImpersonationRegistryModelImpl.OPERATIONDATE_COLUMN_BITMASK);

		_finderPathCountBycompanyId = new FinderPath(
			ImpersonationRegistryModelImpl.ENTITY_CACHE_ENABLED,
			ImpersonationRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycompanyId",
			new String[] {Long.class.getName()});

		_setImpersonationRegistryUtilPersistence(this);
	}

	public void destroy() {
		_setImpersonationRegistryUtilPersistence(null);

		entityCache.removeCache(ImpersonationRegistryImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setImpersonationRegistryUtilPersistence(
		ImpersonationRegistryPersistence impersonationRegistryPersistence) {

		try {
			Field field = ImpersonationRegistryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, impersonationRegistryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IMPERSONATIONREGISTRY =
		"SELECT impersonationRegistry FROM ImpersonationRegistry impersonationRegistry";

	private static final String _SQL_SELECT_IMPERSONATIONREGISTRY_WHERE_PKS_IN =
		"SELECT impersonationRegistry FROM ImpersonationRegistry impersonationRegistry WHERE impersonationRegistryId IN (";

	private static final String _SQL_SELECT_IMPERSONATIONREGISTRY_WHERE =
		"SELECT impersonationRegistry FROM ImpersonationRegistry impersonationRegistry WHERE ";

	private static final String _SQL_COUNT_IMPERSONATIONREGISTRY =
		"SELECT COUNT(impersonationRegistry) FROM ImpersonationRegistry impersonationRegistry";

	private static final String _SQL_COUNT_IMPERSONATIONREGISTRY_WHERE =
		"SELECT COUNT(impersonationRegistry) FROM ImpersonationRegistry impersonationRegistry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"impersonationRegistry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ImpersonationRegistry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ImpersonationRegistry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ImpersonationRegistryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}