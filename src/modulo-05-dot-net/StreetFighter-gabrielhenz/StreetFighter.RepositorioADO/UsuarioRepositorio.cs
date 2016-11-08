using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace StreetFighter.Persistencia
{
    public class UsuarioRepositorioAdo : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioAutenticado(string login, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"].ConnectionString;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "SELECT * FROM Usuarios WHERE Login = @param_login AND Senha = @param_senha;";

                var command = new SqlCommand(sql, connection);

                command.Parameters.Add(new SqlParameter("param_login", login));
                command.Parameters.Add(new SqlParameter("param_senha", senha));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    return ConverterReaderParaUsuario(reader);
                }

                connection.Close();
            }

            return null;
        }


        public void PopularUsuarios(List<Usuario> usuarios)
        {
            foreach (var usuario in usuarios)
            {
                Criar(usuario);
            }
        }

        public void Criar(Usuario usuario)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["StreetFighterConnection"]
                                    .ConnectionString;

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "";
                var parameters = new List<SqlParameter>();

                sql = $"INSERT INTO Usuarios (Login, Senha, Nome) VALUES (@param_login, @param_senha, @param_nome);";

                parameters.Add(new SqlParameter("param_login", usuario.Login));
                parameters.Add(new SqlParameter("param_senha", usuario.Senha));
                parameters.Add(new SqlParameter("param_nome", usuario.Nome));


                var command = new SqlCommand(sql, connection);
                foreach (SqlParameter param in parameters)
                {
                    command.Parameters.Add(param);
                }
                command.ExecuteNonQuery();
                transaction.Complete();
                connection.Close();
            }
        }

        public Usuario BuscarPorId(int id)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"].ConnectionString;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "SELECT * FROM Usuarios WHERE Login = @param_id;";

                var command = new SqlCommand(sql, connection);

                command.Parameters.Add(new SqlParameter("param_id", id));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    return ConverterReaderParaUsuario(reader);
                }

                connection.Close();
            }
            return null;
        }

        public void Atualizar(Usuario usuario)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["StreetFighterConnection"]
                                    .ConnectionString;

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "";
                var parameters = new List<SqlParameter>();

                sql = $"UPDATE Usuarios (Login, Senha, Nome) VALUES (@param_login, @param_senha, @param_nome) WHERE Id = @param.id;";

                parameters.Add(new SqlParameter("param_login", usuario.Login));
                parameters.Add(new SqlParameter("param_senha", usuario.Senha));
                parameters.Add(new SqlParameter("param_nome", usuario.Nome));
                parameters.Add(new SqlParameter("param_id", usuario.Id));


                var command = new SqlCommand(sql, connection);
                foreach (SqlParameter param in parameters)
                {
                    command.Parameters.Add(param);
                }
                command.ExecuteNonQuery();
                transaction.Complete();
                connection.Close();
            }
        }

        private Usuario ConverterReaderParaUsuario(SqlDataReader reader)
        {
            Usuario found = new Usuario(
                id: Convert.ToInt32(reader["Id"]),
                login: reader["Login"].ToString(),
                senha: reader["Senha"].ToString(),
                nome: reader["Nome"].ToString()
                );
            return found;
        }
    }
}
