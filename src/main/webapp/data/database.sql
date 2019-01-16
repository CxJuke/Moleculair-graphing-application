DROP TABLE IF EXISTS molecules;

CREATE TABLE molecules (
  name varchar NOT NULL UNIQUE,
  molecule varchar NOT NULL unique,
  primary key(name)
);

INSERT INTO molecules(name,molecule) VALUES('BackBone','<BB>');
INSERT INTO molecules(name,molecule) VALUES('Glycine','<GLY>');
INSERT INTO molecules(name,molecule) VALUES('Alpha-linolenic acid','<ALA>');
INSERT INTO molecules(name,molecule) VALUES('Aspartic acid','<ASP>');
INSERT INTO molecules(name,molecule) VALUES('Asparagine','<ASN>');
INSERT INTO molecules(name,molecule) VALUES('Serine','<SER>');
INSERT INTO molecules(name,molecule) VALUES('Cysteine','<CYS>');
INSERT INTO molecules(name,molecule) VALUES('Methionine','<MET>');
INSERT INTO molecules(name,molecule) VALUES('Threonine','<THR>');
INSERT INTO molecules(name,molecule) VALUES('Valine','<VAL>');
INSERT INTO molecules(name,molecule) VALUES('Isolucine','<ILE>');
INSERT INTO molecules(name,molecule) VALUES('Leucine','<LEU>');
INSERT INTO molecules(name,molecule) VALUES('Glutamic Acid','<GLU>');
INSERT INTO molecules(name,molecule) VALUES('Glutamine','<GLN>');
INSERT INTO molecules(name,molecule) VALUES('Proline','<PRO>');
INSERT INTO molecules(name,molecule) VALUES('Histidine','<HIS>');
INSERT INTO molecules(name,molecule) VALUES('Phenylalanine','<PHE>');
INSERT INTO molecules(name,molecule) VALUES('Tyrosine','<TYR>');
INSERT INTO molecules(name,molecule) VALUES('Lysine','<LYS>');
INSERT INTO molecules(name,molecule) VALUES('Arginine','<ARG>');
INSERT INTO molecules(name,molecule) VALUES('Tryptophan','<TRP>');