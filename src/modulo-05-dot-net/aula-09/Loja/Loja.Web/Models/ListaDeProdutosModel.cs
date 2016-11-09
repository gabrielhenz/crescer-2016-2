using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ListaDeProdutosModel
    {
        public ListaDeProdutosModel(List<ProdutoModel> produtosModel)
        {
            this.ProdutosModel = produtosModel;
        }

        public List<ProdutoModel> ProdutosModel { get; set; }
    }

    public static class ListaDeProdutosModelExtensions
    {
        public static ListaDeProdutosModel ConverterParaModel(this List<Produto> produtos)
        {
            List<ProdutoModel> produtosModel = new List<ProdutoModel>();
            foreach (Produto produto in produtos)
            {
                produtosModel.Add(produto.ConverterParaModel());
            }
            return new ListaDeProdutosModel(produtosModel);
        }
    }
}