package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 10:38
 * 中文地址生成器
 */
public class AddressGenerator {

    // 地址组成部分
    private static final String[] PROVINCES = ResourceLoader.loadArray("data/chinese_cities.txt");
    private static final String[] STREET_TYPES = ResourceLoader.loadArray("data/chinese_street_types.txt");
    private static final String[] DIRECTIONS = ResourceLoader.loadArray("data/chinese_directions.txt");
    private static final String[] COMMUNITY_TYPES = ResourceLoader.loadArray("data/chinese_community_types.txt");
    private static final String[] BUILDING_TYPES = ResourceLoader.loadArray("data/chinese_building_types.txt");
    private static final String[] ROOM_TYPES = ResourceLoader.loadArray("data/chinese_room_types.txt");

    /**
     * 生成随机中文地址
     *
     * @return 完整中文地址
     */
    public String generate() {
        // 省市区
        String provinceCity = RandomUtils.randomElement(PROVINCES);

        // 街道部分
        String street = generateStreet();

        // 小区部分
        String community = generateCommunity();

        // 楼栋部分
        String building = generateBuilding();

        // 房间号
        String room = generateRoom();

        return provinceCity + street + community + building + room;
    }

    private String generateStreet() {
        String direction = RandomUtils.randomElement(DIRECTIONS);
        String streetType = RandomUtils.randomElement(STREET_TYPES);
        int streetNum = RandomUtils.randomInt(1, 999);
        return direction + streetType + streetNum + "号";
    }

    private String generateCommunity() {
        String communityType = RandomUtils.randomElement(COMMUNITY_TYPES);
        int communityNum = RandomUtils.randomInt(1, 20);
        return communityNum + communityType;
    }

    private String generateBuilding() {
        String buildingType = RandomUtils.randomElement(BUILDING_TYPES);
        int buildingNum = RandomUtils.randomInt(1, 30);
        return buildingNum + buildingType;
    }

    private String generateRoom() {
        String roomType = RandomUtils.randomElement(ROOM_TYPES);
        int roomNum = RandomUtils.randomInt(101, 2000);
        return roomNum + roomType;
    }
}
