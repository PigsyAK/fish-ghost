package com.pigsy;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.extension.ExtensionUnloadingHandler;
import com.pigsy.burp.MyContextMenuItemsProvider;
import com.pigsy.burp.MenuUtil;
import com.pigsy.utils.WorkspaceUtil;


public class BurpExtensionGhost implements BurpExtension, ExtensionUnloadingHandler {
    private final FishGhostTab fishGhostTab = new FishGhostTab();
    public static MontoyaApi api;

    @Override
    public void initialize(MontoyaApi api) {
        BurpExtensionGhost.api = api;
        // set extension name
        api.extension().setName("Fish-Ghost");

        WorkspaceUtil.initEnv();
        WorkspaceUtil.showBanner(api.logging());

        api.userInterface().menuBar().registerMenu(MenuUtil.getMenu());
        api.userInterface().registerSuiteTab("Fish-Ghost", fishGhostTab);
        api.userInterface().registerContextMenuItemsProvider(new MyContextMenuItemsProvider(api));
    }

    @Override
    public void extensionUnloaded() {
        fishGhostTab.removeAll();
    }
}
