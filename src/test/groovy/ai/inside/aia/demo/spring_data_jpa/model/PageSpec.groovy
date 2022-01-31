package ai.inside.aia.demo.spring_data_jpa.model


import spock.lang.Specification

class PageSpec extends Specification {
    def "updateNameでitemNameが更新されること"() {
        given:
        def page = new Page(1L, 1L, "itemName")
        def param = new Page.UpdateParam("itemXXX")

        when:
        page.updateName(param)

        then:
        page.itemName == param.itemName
    }
}
