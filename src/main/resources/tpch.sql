/*
suplier
供应商信息：key + 姓名、地址、电话、国家代码
其中国家代码需要和 nation 表做 join 以获得详细国家信息。
*/

CREATE TABLE `supplier` (
  `s_suppkey` bigint(20) NOT NULL,
  `s_name` char(25) DEFAULT NULL,
  `s_address` varchar(40) DEFAULT NULL,
  `s_nationkey` bigint(20) DEFAULT NULL,
  `s_phone` char(15) DEFAULT NULL,
  `s_acctbal` bigint(20) DEFAULT NULL,
  `s_comment` varchar(101) DEFAULT NULL,
  PRIMARY KEY (`s_suppkey`)
) partition by hash(s_suppkey) partitions 128


/*
nation
国家信息：key + 国家名、地区代号
其中地区代号需要和 region 表做 join 以获得地区详细信息
*/
CREATE TABLE `nation` (
  `n_nationkey` bigint(20) NOT NULL,
  `n_name` char(25) DEFAULT NULL,
  `n_regionkey` bigint(20) DEFAULT NULL,
  `n_comment` varchar(152) DEFAULT NULL,
  PRIMARY KEY (`n_nationkey`)
)


/*
region
地区信息：key + 地区名
*/
CREATE TABLE `region` (
  `r_regionkey` bigint(20) NOT NULL,
  `r_name` char(25) DEFAULT NULL,
  `r_comment` varchar(152) DEFAULT NULL,
  PRIMARY KEY (`r_regionkey`)
)


/*
customer
用户表：key + 姓名、地址、国家代号、电话等
用户表按照 key 做 64 个 hash 分区
*/
CREATE TABLE `customer` (
  `c_custkey` bigint(20) NOT NULL,
  `c_name` varchar(25) DEFAULT NULL,
  `c_address` varchar(40) DEFAULT NULL,
  `c_nationkey` bigint(20) DEFAULT NULL,
  `c_phone` char(15) DEFAULT NULL,
  `c_acctbal` decimal(10,2) DEFAULT NULL,
  `c_mktsegment` char(10) DEFAULT NULL,
  `c_comment` varchar(117) DEFAULT NULL,
  PRIMARY KEY (`c_custkey`),
  UNIQUE KEY `i_c_custkey` (`c_custkey`) LOCAL  BLOCK_SIZE 16384
) partition by hash(c_custkey) partitions 64

/*
part
配件表：key + 配件名、厂商、品牌、类型、大小、包装、零售价
*/
CREATE TABLE `part` (
  `p_partkey` bigint(20) NOT NULL,
  `p_name` varchar(55) DEFAULT NULL,
  `p_mfgr` char(25) DEFAULT NULL,
  `p_brand` char(10) DEFAULT NULL,
  `p_type` varchar(25) DEFAULT NULL,
  `p_size` bigint(20) DEFAULT NULL,
  `p_container` char(10) DEFAULT NULL,
  `p_retailprice` decimal(10,2) DEFAULT NULL,
  `p_comment` varchar(23) DEFAULT NULL,
  PRIMARY KEY (`p_partkey`)
)  partition by hash(p_partkey) partitions 64;

/*
partsupp
配件供应表：配件key + 供应商key + 供应数量、批发价
*/
CREATE TABLE `partsupp` (
  `ps_partkey` bigint(20) NOT NULL,
  `ps_suppkey` bigint(20) NOT NULL,
  `ps_availqty` bigint(20) DEFAULT NULL,
  `ps_supplycost` decimal(10,2) DEFAULT NULL,
  `ps_comment` varchar(199) DEFAULT NULL,
  PRIMARY KEY (`ps_partkey`, `ps_suppkey`),
  UNIQUE KEY `ps_pkey_skey` (`ps_partkey`, `ps_suppkey`) LOCAL  BLOCK_SIZE 16384
)  partition by hash(ps_partkey) partitions 64


/*
orders
零售订单表：订单key + 客户key + 订单状态、订单总价、下单日期、优先级、收银员、发货优先级
*/
CREATE TABLE `orders` (
  `o_orderkey` bigint(20) NOT NULL,
  `o_custkey` bigint(20) NOT NULL,
  `o_orderstatus` char(1) DEFAULT NULL,
  `o_totalprice` decimal(10,2) DEFAULT NULL,
  `o_orderdate` date NOT NULL,
  `o_orderpriority` char(15) DEFAULT NULL,
  `o_clerk` char(15) DEFAULT NULL,
  `o_shippriority` bigint(20) DEFAULT NULL,
  `o_comment` varchar(79) DEFAULT NULL,
  PRIMARY KEY (`o_orderkey`, `o_orderdate`, `o_custkey`),
  KEY `o_orderkey` (`o_orderkey`) LOCAL  BLOCK_SIZE 16384
)
/*
lineitem
订单明细表：订单key + 配件key + 供应商key + 流水号、
数量、价格、折扣、税、明细状态、
发货日期、预计到达日期、实际到达日期、
运单处理策略（原返？拒收退回？等）、运输途径（火车、汽运、邮寄等）
 */
 CREATE TABLE `lineitem` (
  `l_orderkey` bigint(20) NOT NULL,
  `l_partkey` bigint(20) NOT NULL,
  `l_suppkey` bigint(20) NOT NULL,
  `l_linenumber` bigint(20) NOT NULL,
  `l_quantity` bigint(20) NOT NULL,
  `l_extendedprice` decimal(10,2) NOT NULL,
  `l_discount` decimal(10,2) NOT NULL,
  `l_tax` decimal(10,2) NOT NULL,
  `l_returnflag` char(1) DEFAULT NULL,
  `l_linestatus` char(1) DEFAULT NULL,
  `l_shipdate` date NOT NULL,
  `l_commitdate` date DEFAULT NULL,
  `l_receiptdate` date DEFAULT NULL,
  `l_shipinstruct` char(25) DEFAULT NULL,
  `l_shipmode` char(10) DEFAULT NULL,
  `l_comment` varchar(44) DEFAULT NULL,
  PRIMARY KEY (`l_orderkey`, `l_linenumber`, `l_shipdate`, `l_partkey`),
  KEY `i_l_orderkey` (`l_orderkey`) LOCAL  BLOCK_SIZE 16384
)

