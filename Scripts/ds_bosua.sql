/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : qlnh

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-03-20 22:26:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ds_bosua
-- ----------------------------
DROP TABLE IF EXISTS `ds_bosua`;
CREATE TABLE `ds_bosua` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_bo_sua` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dac_diem` text COLLATE utf8_unicode_ci,
  `ngay_nhap` date DEFAULT NULL,
  `can_nang` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_chuong` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_nv` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `delete_flg` tinyint(1) DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for ds_chuong
-- ----------------------------
DROP TABLE IF EXISTS `ds_chuong`;
CREATE TABLE `ds_chuong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_chuong` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vi_tri` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `so_luong` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay_don_ve_sinh` date DEFAULT NULL,
  `delete_flg` tinyint(1) DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for ds_nhanvien
-- ----------------------------
DROP TABLE IF EXISTS `ds_nhanvien`;
CREATE TABLE `ds_nhanvien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_nv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_nv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `sdt` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dia_chi` text COLLATE utf8_unicode_ci,
  `bo_phan` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chuc_danh` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `delete_flg` tinyint(1) DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for ds_quy_trinh
-- ----------------------------
DROP TABLE IF EXISTS `ds_quy_trinh`;
CREATE TABLE `ds_quy_trinh` (
  `id` int(11) NOT NULL,
  `ngay_vat_sua` date DEFAULT NULL,
  `ma_bo_sua` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nang_suat` int(5) DEFAULT NULL,
  `delete_flg` tinyint(1) DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for ds_thiet_bi
-- ----------------------------
DROP TABLE IF EXISTS `ds_thiet_bi`;
CREATE TABLE `ds_thiet_bi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_thiet_bi` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_thiet_bi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_bo_sua` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tinh_trang` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `so_luong` int(5) DEFAULT NULL,
  `mo_ta` text COLLATE utf8_unicode_ci,
  `nha_cung_cap` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `delete_flg` tinyint(1) DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
