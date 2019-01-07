DROP TABLE IF EXISTS Molecules;

CREATE TABLE Molecules (
  moleculename varchar(50) NOT NULL UNIQUE,
  moleculetekst varchar(400) NOT NULL,
  primary key(moleculename)
);

INSERT INTO Molecules(moleculename, moleculetekst)
  VALUES("Watermolecules", "/#=1-3/(o#(H#[1-2]))/");