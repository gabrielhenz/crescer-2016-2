using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public String Imagem { get; set; }

        [Required]
        public String Nome { get; set; }

        [Required]
        [DisplayName("Data Nascimento")]
        public DateTime DataNascimento { get; set; }

        [Required]
        public int Altura { get; set; }

        [Required]
        public Decimal Peso { get; set; }

        [Required]
        public String Origem { get; set; }

        [Required]
        [DisplayName("Golpes Especiais")]
        public String GolpesEspeciais { get; set; }

        [DisplayName("Personagem Oculto")]
        public Boolean PersonagemOculto { get; set; }
    }
}