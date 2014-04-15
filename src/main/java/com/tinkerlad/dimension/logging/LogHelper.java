/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 ******************************************************************************/
package com.tinkerlad.dimension.logging;



import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class LogHelper {

	public static Logger	logger;

	public static void log(Level level, String message) {

		logger.log(level, message);
	}
}
