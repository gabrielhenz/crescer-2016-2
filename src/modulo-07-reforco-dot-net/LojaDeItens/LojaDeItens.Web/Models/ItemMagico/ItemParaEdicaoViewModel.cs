using LojaDeItens.Dominio.ItemMagico;
using LojaDeItens.Web.Validacoes;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaDeItens.Web.Models.ItemMagico
{
    public class ItemParaEdicaoViewModel
    {
        public ItemParaEdicaoViewModel()
        {
        }

        public ItemParaEdicaoViewModel(ItemMagicoEntidade item)
        {
            this.Id = item.Id;
            this.Nome = item.Nome;
            this.Descricao = item.Descricao;
            this.Preco = item.Preco;
            this.Estoque = item.Estoque;
            this.Raro = item.Raro;
        }

        public int? Id { get; set; }

        [Required(ErrorMessage = "O nome do produto é obrigatório.")]
        [StringLength(50)]
        public string Nome { get; set; }

        [Required(ErrorMessage = "A descrição do produto é obrigatória.")]
        [StringLength(200)]
        public string Descricao { get; set; }

        [Required(ErrorMessage = "O preço do produto é obrigatório.")]
        [CustomValidation(typeof(MetodosDeValidacoes), "ValidarMaiorOuIgualAZero")]
        public decimal Preco { get; set; }

        [Required(ErrorMessage = "O estoque do produto é obrigatório.")]
        [Range(0, int.MaxValue, ErrorMessage = "O campo Estoque precisa ser maior ou igual a zero.")]
        public int Estoque { get; set; }

        public bool Raro { get; set; }
    }
}