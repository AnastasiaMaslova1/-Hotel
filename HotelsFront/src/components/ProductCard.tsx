/* eslint-disable @next/next/no-img-element */
import { FC } from "react";
import Link from "next/link";

import { Product } from "~/types";

type ProductCardProps = {
  product: Product;
};
//карта, которую видит пользователь, не открывая подробностей
export const ProductCard: FC<ProductCardProps> = ({ product }) => {
  return (
    <Link href={`/reservation/${product.id}`}>
      <div className="flex flex-col gap-3">
        <div className="flex h-96 items-center justify-center bg-white p-4">
          <img
            className="h-full w-full object-contain"
            src={product.image} //изображение
            alt={product.nameclient} //имя клиента
          />
        </div>
        <p className="overflow-hidden text-ellipsis whitespace-nowrap">
          {product.nameclient}
        </p>
      </div>
    </Link>
  );
};
