/*
 * Sentilo
 *   
 * Copyright (C) 2013 Institut Municipal d’Informàtica, Ajuntament de  Barcelona.
 *   
 * This program is licensed and may be used, modified and redistributed under the
 * terms  of the European Public License (EUPL), either version 1.1 or (at your 
 * option) any later version as soon as they are approved by the European 
 * Commission.
 *   
 * Alternatively, you may redistribute and/or modify this program under the terms
 * of the GNU Lesser General Public License as published by the Free Software 
 * Foundation; either  version 3 of the License, or (at your option) any later 
 * version. 
 *   
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. 
 *   
 * See the licenses for the specific language governing permissions, limitations 
 * and more details.
 *   
 * You should have received a copy of the EUPL1.1 and the LGPLv3 licenses along 
 * with this program; if not, you may find them at: 
 *   
 *   https://joinup.ec.europa.eu/software/page/eupl/licence-eupl
 *   http://www.gnu.org/licenses/ 
 *   and 
 *   https://www.gnu.org/licenses/lgpl.txt
 */
package org.sentilo.agent.alert.utils;

import org.sentilo.agent.alert.domain.Alarm;

import org.sentilo.common.utils.SentiloConstants;
import org.sentilo.common.utils.DateUtils;

public abstract class AlertUtils {
	
	private AlertUtils(){
		throw new AssertionError();
	}
	
	public static String buildDataTopicAssociateToAlarm(Alarm alarm){		
		return Constants.DATA+Constants.REDIS_KEY_TOKEN+alarm.getProviderId()+Constants.REDIS_KEY_TOKEN+alarm.getSensorId();
	}
	
	public static String buildTopicToPublishAlarm(Alarm alarm){		
		return Constants.ALARM+Constants.REDIS_KEY_TOKEN+alarm.getId();
	}
	
	public static String buildMessageToPublish(String value){		
		Long timestamp  = System.currentTimeMillis();
		return DateUtils.timestampToString(timestamp) + SentiloConstants.NOTIFICATION_MESSAGE_TOKEN + value;		
	}
}