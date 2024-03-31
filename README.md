# API de Supermercado

## Descripción
Esta API proporciona endpoints para administrar productos de un supermercado.

## Cómo Configurar y Ejecutar el Proyecto
1. Instalar Java y Spring Boot.
2. Clonar este repositorio.
3. Configurar el archivo `application.properties`.
4. Ejecutar la aplicación utilizando `mvn spring-boot:run`.

## Ejemplos de Uso
### Obtener todos los productos
```http
GET /api/supermercado
```

### Obtener un producto por código
```http
GET /api/supermercado/{codigo}
```

### Crear un nuevo producto
```http
POST /api/supermercado
```
Body:
```json
{
    "codigo": 1201,
    "nombre": "Nuevo Producto",
    "precio": "20.000 pesos",
    "categoria": "Nueva Categoria",
    "peso": "500 gm"
}
```

### Actualizar un producto existente
```http
PUT /api/supermercado/{codigo}
```
Body:
```json
{
    "nombre": "Producto Actualizado",
    "precio": "25.000 pesos",
    "categoria": "Categoria Actualizada",
    "peso": "700 gm"
}
```

### Eliminar un producto
```http
DELETE /api/supermercado/{codigo}
```

## Modelo de Datos
El modelo de datos utilizado para representar un producto es la clase `Producto`, que contiene los siguientes atributos:
- Codigo
- Nombre
- Precio
- Categoria
- Peso

## Controlador
El controlador `ProductoController` se utiliza para manejar las solicitudes HTTP en la API.

## JSON de Ejemplo
```json
[
    {
        "codigo": 1200,
        "nombre": "Pan Artesanal",
        "precio": "10.000 pesos",
        "categoria": "Parva",
        "peso": "340 gm"
    },
    ...
]
```


