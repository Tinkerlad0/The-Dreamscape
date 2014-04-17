package com.tinkerlad.dimension.entity.particle.updater;

import com.tinkerlad.dimension.entity.particle.ParticleFX;
import com.tinkerlad.dimension.modules.Vector3;

/**
 * Kybology
 * 
 * UpdaterEnergyTrail
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class UpdaterEnergyTrail extends IParticleUpdater {

	private Vector3	dest;

	public UpdaterEnergyTrail(Vector3 destination) {
		this.dest = destination;
	}

	@Override
	public void onUpdate(ParticleFX fx) {
		double motionX = (dest.x - fx.getStartPosition().x) / fx.ticksLifespan;
		double motionY = (dest.y - fx.getStartPosition().y) / fx.ticksLifespan;
		double motionZ = (dest.z - fx.getStartPosition().z) / fx.ticksLifespan;

		fx.moveEntity(motionX, motionY, motionZ);
	}

}