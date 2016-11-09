using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public int? Id { get; set; }

        [Required]
        public String Nome { get; set; }

        [Required]
        [DataType("decimal(18 ,2")]
        [DisplayName("Valor: R$")]
        public Decimal Valor { get; set; }   
    }

    public static class ProdutoModelExtensions
    {
        public static ProdutoModel ConverterParaModel(this Produto produto)
        {
            return new ProdutoModel()
            {
                Nome = produto.Nome
            };
        }
    }
}