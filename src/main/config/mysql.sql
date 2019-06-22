# 创建分类热度值表
CREATE TABLE `grouphotvalue` (
  `name` varchar(50) DEFAULT NULL COMMENT '分类名字',
  `hotValue` int(11) DEFAULT NULL COMMENT '热度值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 创建分类详细信息表
CREATE TABLE `groupinfo` (
  `name` varchar(20) NOT NULL COMMENT '分类名',
  `iconUrl` varchar(500) DEFAULT NULL COMMENT '分类展示图标的url',
  `groupUrl` varchar(500) DEFAULT NULL COMMENT '分类的url',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 创建房间热度值表
CREATE TABLE `roomhotvalue` (
  `roomId` int(11) DEFAULT NULL COMMENT '房间号',
  `hotValue` int(11) DEFAULT NULL COMMENT '热度值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 创建房间信息表
CREATE TABLE `roominfo` (
  `roomId` int(11) NOT NULL COMMENT '房间id',
  `zbName` varchar(100) DEFAULT NULL COMMENT '主播名字',
  `liveType` varchar(50) DEFAULT NULL COMMENT '直播分类',
  `roomUrl` varchar(500) DEFAULT NULL COMMENT '房间url',
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建房间送礼表
CREATE TABLE `giftrecord` (
  `rid` int(11) DEFAULT NULL COMMENT '房间ID',
  `gfid` int(11) DEFAULT NULL COMMENT '礼物id',
  `isfree` int(1) DEFAULT NULL COMMENT '1为收费，0为免费',
  `gfname` varchar(50) DEFAULT NULL COMMENT '礼物的名字',
  `uid` int(11) DEFAULT NULL COMMENT '送礼物玩家的id',
  `nn` varchar(70) DEFAULT NULL COMMENT '送礼物玩家的名称',
  `level` int(11) DEFAULT NULL COMMENT '送礼物玩家的等级',
  `gfcnt` int(11) DEFAULT NULL COMMENT '礼物个数：默认值为1',
  `jiage` double DEFAULT NULL COMMENT '收费礼物值多少RMB',
  `gifttime` bigint(20) DEFAULT NULL COMMENT '收到礼物的时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建礼物道具信息表
CREATE TABLE `giftinfo` (
  `id` varchar(10) NOT NULL COMMENT '礼物的id字符串形式',
  `name` varchar(50) DEFAULT NULL COMMENT '礼物的名字',
  `giftType` int(1) DEFAULT NULL COMMENT '0免费，1收费',
  `price` double DEFAULT NULL COMMENT '价格，RMB',
  `priceName` varchar(15) DEFAULT NULL COMMENT '价格的字符串描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
