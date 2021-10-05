




CREATE TABLE statuses  (
  id  SERIAL  NOT NULL,
  active boolean,
  inservice boolean,
  functional boolean,
  PRIMARY KEY(id)
);

CREATE TABLE cities (
  id SERIAL NOT NULL,
  code varchar(30),
  PRIMARY KEY(id)
);

CREATE TABLE regions (
  id SERIAL NOT NULL,
  code varchar(10),
  shortName varchar(30),
  cityid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_cities FOREIGN KEY(cityid) REFERENCES cities(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE addresses (
  id SERIAL NOT NULL,
  country varchar(50),
  cityid integer,
  province varchar,
  regionid integer,
  Street varchar(50),
  civicNumber varchar(30),
  PRIMARY KEY(id),
  CONSTRAINT fk_cities FOREIGN KEY(cityid) REFERENCES cities(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_regions FOREIGN KEY(regionid) REFERENCES regions(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE buildings  (
  id SERIAL NOT NULL,
  shortName varchar(30),
  adressid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_adresses FOREIGN KEY(adressid) REFERENCES addresses(id)  ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE onus (
  id SERIAL NOT NULL,
  serialNumber integer,
  shortName varchar(30),
  buildingid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_buildings FOREIGN KEY(buildingid) REFERENCES buildings(id) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE beps (
  id SERIAL NOT NULL,
  types varchar(30),
  coordinates varchar(50),
  regionid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_regions FOREIGN KEY(regionid) REFERENCES regions(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE racks (
  id SERIAL NOT NULL,
  model varchar(50),
  height integer,
  width integer,
  lengths  integer,
  slotsize integer,
  roomnumber varchar(30),
  buildingid integer,
  PRIMARY KEY(id),
  CONSTRAINT  fk_buildings FOREIGN KEY(buildingid) REFERENCES buildings(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE olts (
  id SERIAL NOT NULL,
  model varchar(30),
  slots integer,
  height integer,
  width integer,
  lengths integer,
  rackid integer,
  statusid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_racks FOREIGN KEY(rackid) REFERENCES racks(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_statuses FOREIGN KEY(statusid) REFERENCES statuses(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE sfps (
  id SERIAL NOT NULL,
  oltid integer,
  statusid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_olts FOREIGN KEY(oltid) REFERENCES olts(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_statuses FOREIGN KEY(statusid) REFERENCES statuses (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE splitters (
  id  SERIAL NOT NULL,
  splitterRatio varchar(10),
  model varchar(30),
  statusid  integer,
  bepid integer,
  rackid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_statuses FOREIGN KEY(statusid) REFERENCES statuses(id)  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_beps FOREIGN KEY(bepid) REFERENCES beps(id)  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_racks FOREIGN KEY(rackid) REFERENCES racks(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cables (
  id SERIAL NOT NULL,
  lengths integer,
  manufacturer varchar(50),
  statusid integer,
  PRIMARY KEY(id),
  CONSTRAINT fk_statuses FOREIGN KEY(statusid) REFERENCES statuses(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE connectors (
	id SERIAL NOT NULL,
	statusid integer ,
	onuid integer ,
	splitterid integer ,
	sfpid integer ,
	cableid integer ,
  PRIMARY KEY(id),
  CONSTRAINT fk_statuses FOREIGN KEY(statusid) REFERENCES statuses(id)  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_onus FOREIGN KEY(onuid)  REFERENCES onus(id)  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_splitters FOREIGN KEY(splitterid) REFERENCES splitters(id)  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_cables FOREIGN KEY(cableid) REFERENCES cables(id)  ON DELETE CASCADE ON UPDATE CASCADE
);
