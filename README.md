# Grails with Htmx

Grails Plugin for using Grails with htmx.


## Usage

Add dependency to the `build.gradle`,

```gradle

repositories {
    mavenCentral()
}

dependencies {

    // Grails 4
    compile "org.rainboyan.plugins:grails-plugin-htmx:0.0.2"

    // Grails 5+
    implementation "org.rainboyan.plugins:grails-plugin-htmx:0.0.2"
}
```

Htmx plugin supports controller-specific `withFormat()` method,

```groovy
class BookController {

    def list() {
        def books = Book.list()

        withFormat {
            htmx {
                render(template: "book", model: [bookList: books])
            }
            json {
                render books as JSON
            }
        }
    }
}
```

Also, this plugin supports extendsions for Grails Request and Response,

```groovy
// You can get htmx request headers from Grails Request

request.htmx.boosted == request.getHeader('HX-Boosted')
request.htmx.target  == request.getHeader('HX-Target')

// Check htmx request?
if (request.htmx as boolean) { // or use request.isHtmx()
    template = 'book-detail'
}

// You can set htmx response headers in Grails

response.htmx.trigger = 'itemAdded'

```

## Example

* [Grails Htmx TodoMVC](https://github.com/rainboyan/grails-htmx-todomvc)

## Development

### Build from source

```
git clone https://github.com/rainboyan/grails-htmx.git
cd grails-htmx
./gradlew publishToMavenLocal
```

## Support Grails Version

* Grails 4.0, 4.1
* Grails 5.0, 5.1, 5.2, 5.3
* Grails 6.0

## Roadmap

### 1.x

* Htmx 1.9

### 2.x

* Htmx 2.0

## License

This plugin is available as open source under the terms of the [APACHE LICENSE, VERSION 2.0](http://apache.org/Licenses/LICENSE-2.0)

## Links

- [Grails Website](https://grails.org)
- [Grails Plugins](https://docs.grails.org/4.0.0/guide/plugins.html)
- [Grails Htmx Plugin](https://github.com/rainboyan/grails-htmx)
- [Grails Htmx TodoMVC](https://github.com/rainboyan/grails-htmx-todomvc)
