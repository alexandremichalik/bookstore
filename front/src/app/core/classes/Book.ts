export class Book {
  ean13: string;
  nbCopies: number;
  serie: string;
  tome: string;
  title: string;
  format: string;
  language: string;
  legalDepositDate: string;
  genre: string;
  description: string;
  nbPages: number;
  author: string;
  illustrator: string;
  loanPeriod: number;

  constructor(
    ean13: string,
    nbCopie: number,
    serie: string,
    tome: string,
    title: string,
    format: string,
    language: string,
    legalDepositDate: string,
    genre: string,
    description: string,
    nbPages: number,
    author: string,
    illustrator: string,
    loanPeriod: number,
  ) {
    this.ean13 = ean13;
    this.nbCopies = nbCopie;
    this.serie = serie;
    this.tome = tome;
    this.title = title;
    this.format = format;
    this.language = language;
    this.legalDepositDate = legalDepositDate;
    this.genre = genre;
    this.description = description;
    this.nbPages = nbPages;
    this.author = author;
    this.illustrator = illustrator;
    this.loanPeriod = loanPeriod;
  }
}
