/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/5/16 ÏÂÎç 09:37:43                        */
/*==============================================================*/


/*==============================================================*/
/* Table: t_comment                                             */
/*==============================================================*/
create table t_comment
(
   id                   int not null auto_increment,
   t_u_id               int,
   content              text,
   kind                 int,
   target               int not null,
   del                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_dealorder                                           */
/*==============================================================*/
create table t_dealorder
(
   id                   int not null auto_increment,
   t_u_id               int,
   t_h_id               int,
   ordernum             varchar(50),
   checkindate          date,
   checkoutdate         date,
   unitprice            float(8),
   orderdate            datetime,
   checktime            timestamp,
   total                float(8),
   state                int,
   commentstate         int,
   del                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_house                                               */
/*==============================================================*/
create table t_house
(
   id                   int not null auto_increment,
   t_u_id               int,
   name                 varchar(50),
   bill                 int,
   renttype             int,
   kind                 int,
   area                 float,
   guestnum             int,
   bednum               int,
   bedroomnum           int,
   roomnum              int,
   bedtype              varchar(50),
   toiletnum            int,
   roomdesc             text,
   userule              text,
   facility             text,
   address              text,
   picture1             varchar(200),
   picture2             varchar(200),
   picture3             varchar(200),
   shotcut1             varchar(200),
   shotcut2             varchar(200),
   shotcut3             varchar(200),
   checkinTime          varchar(50),
   checkoutTime         varchar(50),
   minday               int,
   maxday               int,
   refundday            int,
   payrule              varchar(50),
   dayprice             float(8),
   createtime           timestamp,
   state                int,
   del                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_manager                                             */
/*==============================================================*/
create table t_manager
(
   id                   int not null auto_increment,
   name                 varchar(50),
   password             varchar(50),
   del                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_message                                             */
/*==============================================================*/
create table t_message
(
   id                   int not null auto_increment,
   t_u_id               int,
   content              text,
   target               int,
   state                int,
   del                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   id                   int not null auto_increment,
   t_u_id               int,
   t_h_id               int,
   ordernum             varchar(50),
   checkindate          date,
   checkoutdate         date,
   state                int,
   unitprice            float(8),
   orderdate            timestamp,
   commentstate         int,
   total                float(8),
   del                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_rentlock                                            */
/*==============================================================*/
create table t_rentlock
(
   id                   int not null auto_increment,
   t_h_id               int,
   rentdate             date,
   state                int,
   del                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment,
   name                 varchar(50),
   password             varchar(50),
   sex                  int,
   mobile               varchar(50),
   email                varchar(50),
   address              varchar(100),
   picture              varchar(50),
   del                  int,
   primary key (id)
);

alter table t_comment add constraint FK_FK_user_comment foreign key (t_u_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_dealorder add constraint FK_FK_house_dealorder foreign key (t_h_id)
      references t_house (id) on delete restrict on update restrict;

alter table t_dealorder add constraint FK_Relationship_6 foreign key (t_u_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_house add constraint FK_Relationship_5 foreign key (t_u_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_message add constraint FK_Relationship_4 foreign key (t_u_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_order add constraint FK_FK_user_order foreign key (t_u_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_order add constraint FK_Relationship_7 foreign key (t_h_id)
      references t_house (id) on delete restrict on update restrict;

alter table t_rentlock add constraint FK_Relationship_8 foreign key (t_h_id)
      references t_house (id) on delete restrict on update restrict;

