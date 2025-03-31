package com.codbex.hades.integration.tests;

import org.eclipse.dirigible.integration.tests.ui.tests.DatabasePerspectiveIT;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({//
        DatabasePerspectiveIT.class, //
})
public class DirigibileCommonTestSuiteIT {
}
