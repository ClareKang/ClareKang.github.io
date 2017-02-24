package net.meshkorea.mcp.api.entity.pricing;

/**
 * Created by jihunlee on 2016. 2. 26..
 */
public enum RegionType {
    CITY_DO(0),
    GU_GUN(1),
    EUP_MYEON_DONG(2),
    RI(3);

	private Integer depth;

	RegionType(Integer depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}
}