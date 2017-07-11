USE videoteca;

SELECT

  p.titulo,
  g.descripcion as genero,
  CONCAT(a.nombre, ' ', a.apellidos) as interprete,
  CONCAT(d.nombre, ' ', d.apellidos) as director

FROM

  pelicula p

  JOIN genero g
  ON g.id = p.idgenero

  JOIN directores_por_pelicula dpp
  ON dpp.idpelicula = p.id

  JOIN director d
  ON d.id = dpp.iddirector

  JOIN actores_por_pelicula app
  ON app.idpelicula = p.id

  JOIN actor a
  ON a.id = dpp.iddirector;