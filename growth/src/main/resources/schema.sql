CREATE TABLE location (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  Country varchar(100) NOT NULL,
  State varchar(100) DEFAULT NULL,
  City varchar(100) DEFAULT NULL,
  Zipcode varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

CREATE TABLE person (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  FirstName varchar(50) NOT NULL,
  LastName varchar(50) NOT NULL,
  EmailID varchar(100) NOT NULL,
  Password varchar(50) NOT NULL,
  Photo varchar(200) NOT NULL,
  BirthDate date NOT NULL,
  PhoneNumber varchar(20) NOT NULL,
  Gender enum('MALE','FEMALE') DEFAULT NULL,
  AccountStatus enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE'
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

CREATE TABLE host (
  host_id int(11) PRIMARY KEY,
  BankName varchar(100) NOT NULL,
  AccountTYpe enum('CHECKING','SAVINGS') NOT NULL,
  AccountNumber varchar(20) NOT NULL,
  RoutingNumber varchar(20) NOT NULL,
  CONSTRAINT fk_HOST_PERSON1 FOREIGN KEY (host_id) REFERENCES person (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE house (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  StreetNumber varchar(10) NOT NULL,
  StreetName varchar(100) NOT NULL,
  AptNumber varchar(10) NOT NULL,
  Availability enum('AVAILABLE','BOOKED') NOT NULL,
  CostPerNight double NOT NULL,
  LocationID int(11) NOT NULL,
  HostID int(11) NOT NULL,
  CONSTRAINT fk_HOUSE_HOST1 FOREIGN KEY (HostID) REFERENCES host (host_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_HOUSE_LOCATION1 FOREIGN KEY (LocationID) REFERENCES location (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE customer (
  customer_id int(11) PRIMARY KEY,
  PaymentType varchar(45) NOT NULL,
  CardNumber varchar(20) NOT NULL,
  SecurityCode varchar(5) NOT NULL,
  NameOnCard varchar(100) NOT NULL,
  CONSTRAINT fk_CUSTOMER_PERSON1 FOREIGN KEY (customer_id) REFERENCES person (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE booking (
  id int(11) PRIMARY KEY,
  BookingStartDate BIGINT(20) NOT NULL,
  BookingEndDate BIGINT(20) NOT NULL,
  BookingStatus enum('OPEN','CANCELLED') NOT NULL,
  HouseID int(11) NOT NULL,
  CustomerID int(11) NOT NULL,
  FinalCost double DEFAULT NULL,
  TimeStamp datetime(6) DEFAULT NULL,
  CONSTRAINT fk_BOOKING_CUSTOMER1 FOREIGN KEY (CustomerID) REFERENCES customer (customer_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_BOOKING_HOUSE1 FOREIGN KEY (HouseID) REFERENCES house (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

