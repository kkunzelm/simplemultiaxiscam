package biz.wolschon.cam.multiaxis.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

/**
 * A collision between a triangle and something else in a given collision point.
 * @author marcuswolschon
 *
 */
public class Collision {

	private Triangle triangle;
	private Vector3D collisionPoint;
	@SuppressWarnings("unused")
	private double u;
	@SuppressWarnings("unused")
	private double v;
	private double toolLocation;
	/**
	 * 
	 * @param triangle the triangle to collide with
	 * @param p collision point in 3D space.
	 * @param u collision point as given by the fist vector of the triangle
	 * @param v collision point as given by the second vector of the triangle
	 */
	protected Collision(final Triangle triangle, final Vector3D p, final double u, final double v, final double toolLocation) {
		if (p.isInfinite() || p.isNaN()) {
			throw new IllegalArgumentException("One coordinate of the collision point is NaN or Infinity");
		}
		this.toolLocation = toolLocation;
		this.triangle = triangle;
		this.collisionPoint = p;
		this.u = u;
		this.v = v;
	}
	public Vector3D getCollisionPoint() {
		return collisionPoint;
	}
	public Triangle getCollidingPolygon() {
		return triangle;
	}
	/**
	 * 
	 * @return offset of the tool-segment that collides with the tool-tip
	 */
	public double getToolLocation() {
		return toolLocation;
	}
	@Override
	public String toString() {
		return "[colliding with " + triangle + " at " + getCollisionPoint() + " using " + toolLocation + "]";
	}
}
