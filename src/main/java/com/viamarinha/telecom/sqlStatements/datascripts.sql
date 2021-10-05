
--adding data to a status table
INSERT INTO statuses(  active, inservice, functional) VALUES( true, true, true);
INSERT INTO statuses(  active, inservice, functional) VALUES( 'f', 'f', 'f');
INSERT INTO statuses(  active, inservice, functional) VALUES( 't', 'f', 't');
INSERT INTO statuses(  active, inservice, functional) VALUES( false, true, false);

-- adding values to city table
INSERT INTO cities( id , code) VALUES(1, 'kiev');
INSERT INTO cities( id , code) VALUES(2, 'odessa');
INSERT INTO cities( id , code) VALUES(3, 'kharkiv');
INSERT INTO cities( id , code) VALUES(4, 'dnipro');

--adding data to a rigion table
INSERT INTO regions(  code, shortName, cityid) VALUES( 'pech', 'pecherskiy', 1);
INSERT INTO regions(  code, shortName, cityid) VALUES( 'obl', 'obolonskiy', 1);
INSERT INTO regions(  code, shortName, cityid) VALUES( 'svt', 'svyatoshinskiy', 1);
INSERT INTO regions(  code, shortName, cityid) VALUES( 'cher', 'cheremushki', 2);
INSERT INTO regions(  code, shortName, cityid) VALUES( 'mld', 'moldavanka', 2);

--adding data to a address table
INSERT INTO addresses( country, cityid, province, regionid, Street, civicNumber)
 VALUES( 'ukraine', 1, 'kiev', 1, 'maidan', '25' );
INSERT INTO addresses( country, cityid, province, regionid, Street, civicNumber)
 VALUES( 'ukraine', 1, 'kiev', 2, 'shevchenko', '12A' );
INSERT INTO addresses( country, cityid, province, regionid, Street, civicNumber)
 VALUES( 'ukraine', 2, 'odessa', 4, 'derebassovskaya', '12458' );
INSERT INTO addresses( country, cityid, province, regionid, Street, civicNumber)
 VALUES( 'ukraine', 2, 'odessa', 5, 'dalnitskaya', '25' );

 --adding data to a building table
 INSERT INTO buildings(  shortName, adressid) VALUES( 'admin', 1);
 INSERT INTO buildings(  shortName, adressid) VALUES( 'rodeo', 2);
 INSERT INTO buildings(  shortName, adressid) VALUES( 'westmount', 3);
 INSERT INTO buildings(  shortName, adressid) VALUES( 'montroyal', 3);

 --adding data to a onu table
 INSERT INTO onus( serialNumber, shortName, buildingid) VALUES ( 15422, 'stive', 1);
 INSERT INTO onus( serialNumber, shortName, buildingid) VALUES ( 587444, 'olga', 2);
 INSERT INTO onus( serialNumber, shortName, buildingid) VALUES ( 15422, 'morrison', 3);
 INSERT INTO onus( serialNumber, shortName, buildingid) VALUES ( 15422, 'delta', 4);

 --adding data to a bep table
 INSERT INTO beps( types, coordinates, regionid) VALUES( 'outside', '45.610729 x -73.553627', 1);
 INSERT INTO beps( types, coordinates, regionid) VALUES( 'underground', '28.610729 x -93.473627', 2);
 INSERT INTO beps( types, coordinates, regionid) VALUES( 'indoor', '25.610729 x -33.553627', 3);
 INSERT INTO beps( types, coordinates, regionid) VALUES( 'outside', '55.610729 x -7.548774', 4);

 --adding data to a rack table

INSERT INTO racks( model, height, width, lengths, slotsize, roomnumber, buildingid)
           VALUES( 'G3855', 10, 50, 35 , 19, '10A', 1);
INSERT INTO racks( model, height, width, lengths, slotsize, roomnumber, buildingid)
           VALUES( 'MA5683T', 15, 55, 38 , 19, '108', 1);
INSERT INTO racks( model, height, width, lengths, slotsize, roomnumber, buildingid)
           VALUES( 'G3855', 10, 40, 69 , 19, '69', 3);
INSERT INTO racks( model, height, width, lengths, slotsize, roomnumber, buildingid)
           VALUES( 'G3855', 10, 40, 69 , 19, '69', 4);
INSERT INTO racks( model, height, width, lengths, slotsize, roomnumber, buildingid)
           VALUES( 'G3855', 10, 40, 69 , 19, '69', 2);

--adding data to a olt table
INSERT INTO olts( model, slots, height, width, lengths, rackid, statusid)
          VALUES( 'AN-E-OLT-1000', 8, 10, 15, 25, 1, 3);
INSERT INTO olts( model, slots, height, width, lengths, rackid, statusid)
          VALUES( 'EA5801-GP08-AC', 16, 10, 15, 25, 2, 2);

--adding data to a sfp table
INSERT INTO sfps( oltid, statusid) VALUES( 2, 1);
INSERT INTO sfps( oltid, statusid) VALUES( 2, 3);

--adding data to a splitter table
INSERT INTO splitters( splitterRatio, model, statusid, bepid, rackid) VALUES( '1:2', 'twinkle', 1, 2, 2);
INSERT INTO splitters( splitterRatio, model, statusid, bepid, rackid) VALUES( '1:32', 'exo', 3, 1, 5);

--adding data to a canle table
INSERT INTO cables( lengths, manufacturer, statusid) VALUES( 250, 'denzo', 1);
INSERT INTO cables( lengths, manufacturer, statusid) VALUES( 20, 'okobono', 4);
INSERT INTO cables( lengths, manufacturer, statusid) VALUES( 450, 'denzo', 1);
INSERT INTO cables( lengths, manufacturer, statusid) VALUES( 5, 'okobono', 3);

--adding data to a connector table
INSERT INTO connectors( statusid, onuid, splitterid, sfpid, cableid)
                VALUES( 1, 2, 1, 2, 1);
INSERT INTO connectors( statusid, onuid, splitterid, sfpid, cableid)
                VALUES( 2, 2, 2, 1, 1);
