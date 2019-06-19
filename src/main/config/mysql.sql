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
) ENGINE=InnoDB DEFAULT CHARSET=utf8
