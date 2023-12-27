export type ProductsSort = "asc" | "desc";

export type ProductsLimit = "5" | "10" | "20";

export type ProductsRequestParams = {
  sort: ProductsSort;
  limit: ProductsLimit;
};

export type Product = {
  id: number;
  datestart: string;
  dateend: number;
  numberroom: number;
  nameclient: string;
  image: string;
  rating: {
    rate: number;
    count: number;
  };
  needs: string;
  status: number;
};

export type ProductCreate = {
  numberroom: number;
  nameclient: string;
  datestart: string;
  dateend: string;
  status: number;
  image: string;
};

export type ProductUpdate = ProductCreate;
