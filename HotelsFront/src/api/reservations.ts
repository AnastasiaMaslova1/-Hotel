import { Product, ProductsRequestParams } from "~/types";
import { apiInstance } from "./instance";

//методы (вызывает функции из бэка)
export const getProducts = (params?: ProductsRequestParams) => {
  return apiInstance.get<Product[]>("/reservations", { params });
};

export const getProductById = (id: number) => {
  return apiInstance.get<Product>(`/reservations/${id}`);
};
