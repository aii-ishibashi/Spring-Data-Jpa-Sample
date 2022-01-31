package ai.inside.aia.demo.spring_data_jpa.model


import spock.lang.Specification


class UnitSpec extends Specification {

    def "setPageでpageモデルが追加されること"() {
        given:
        def unit = new Unit(1L, "name", [] as Set)
        def param = new Page.RegisterParam(1L, "pageName")

        when:
        unit.setPage(param)

        then:
        unit.pages.size() == 1
    }

    def "updateNameでnameがupdateされること"() {
        given:
        def unit = new Unit(1L, "name", [] as Set)
        def param = new Unit.UpdateParam("nameXXX")

        when:
        unit.updateName(param)

        then:
        unit.name == param.name
    }
}
