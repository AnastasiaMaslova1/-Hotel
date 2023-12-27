import { type AppType } from "next/dist/shared/lib/utils";
import { Layout } from "~/components";

import "~/styles/globals.css";
//системное
const MyApp: AppType = ({ Component, pageProps }) => {
  return (
    <Layout>
      <Component {...pageProps} />
    </Layout>
  );
};

export default MyApp;
