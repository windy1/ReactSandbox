/*
 * This file is part of ReactSandbox.
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 * ReactSandbox is licensed under the Spout License Version 1.
 *
 * ReactSandbox is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * ReactSandbox is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.reactsandbox;

import org.spout.math.vector.Vector2;
import org.spout.renderer.data.Uniform.IntUniform;
import org.spout.renderer.data.Uniform.Vector2Uniform;
import org.spout.renderer.data.UniformHolder;

public class BlurEffect {
	private final int blurSize;
	private final Vector2 texelSize;

	public BlurEffect(Vector2 resolution, int blurSize) {
		this.blurSize = blurSize;
		this.texelSize = Vector2.ONE.div(resolution);
	}

	public void dispose() {
	}

	public void addUniforms(UniformHolder destination) {
		destination.add(new IntUniform("blurSize", blurSize));
		destination.add(new Vector2Uniform("texelSize", texelSize));
	}
}
