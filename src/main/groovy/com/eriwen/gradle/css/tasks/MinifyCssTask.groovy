/**
 * Copyright 2011 Eric Wendelin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.eriwen.gradle.css.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import com.yahoo.platform.yui.compressor.CssCompressor

class MinifyCssTask extends DefaultTask {
	String charset = 'UTF-8'
	Integer lineBreakPos = -1
	def inputFile
	def outputFile

	@TaskAction
	def run() {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(inputFile), charset)
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFile), charset)
		CssCompressor compressor = new CssCompressor(reader)
		compressor.compress(writer, lineBreakPos)
	}
}