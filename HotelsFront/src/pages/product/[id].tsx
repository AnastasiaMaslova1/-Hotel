import { GetServerSideProps } from "next";
import Head from "next/head";
import { FC } from "react";

import { Product } from "~/types";
import { api } from "~/api";

type ProductPageProps = {
  product: Product;
};
//страница моего продукта(подробности)
const ProductPage: FC<ProductPageProps> = ({ product }) => {
  return (
    <>
      <Head>
        <title>{product.nameclient}</title>
        <meta name="description" content={product.nameclient} />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <section>
        <h1 className="text-4xl font-bold text-slate-800">{product.nameclient}</h1>
      </section>
    </>
  );
};

export default ProductPage;

export const getServerSideProps: GetServerSideProps<ProductPageProps> = async (
  ctx,
) => {
  const { params } = ctx;

  const id = params?.id;

  if (typeof id !== "string") {
    return {
      notFound: true,
    };
  }

  const numberId = parseInt(id);

  if (Number.isNaN(numberId)) {
    return {
      notFound: true,
    };
  }
//вызов из под api 
  const response = await api.products.getProductById(numberId);

  return { props: { product: response.data } };
};
