import { useMutation, useQueryClient } from "@tanstack/react-query";
import client from "../clientAPI";
import { toast } from "react-toastify";
type Body = {
  session_id: string | null;
  product_id: string | null | undefined;
};
const addProductToCart = async (body: Body) => {
  return await client.post(
    `cart/product/${body?.product_id}?quantity=1&session_id=${body?.session_id}`
  );
};
const useAddProductToCart = () => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (body: Body) => addProductToCart(body),
    onMutate: () => {
      console.log("mutate");
    },
    onError: (error) => {
      console.log(error);
      toast.error("Something wrong happened");
    },
    onSuccess: (data, variables) => {
      console.log(data);
      toast.success(`Add product ${variables.product_id} successfully`);
      queryClient.invalidateQueries({
        queryKey: ["product", variables.product_id],
      });
      queryClient.invalidateQueries({ queryKey: ["cart"] });
    },
    onSettled: () => {},
  });
};

export default useAddProductToCart;