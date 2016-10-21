package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.consumers.*;
import com.sortedbits.functionaljava.functions.*;
import com.sortedbits.functionaljava.suppliers.SuppliersTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    FunctionsTestSuite.class,
    ConsumersTestSuite.class,
    SuppliersTestSuite.class
})
public class AllTestsSuite {

}



