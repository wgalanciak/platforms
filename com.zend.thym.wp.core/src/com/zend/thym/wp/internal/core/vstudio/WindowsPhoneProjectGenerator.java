package com.zend.thym.wp.internal.core.vstudio;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.thym.core.engine.HybridMobileLibraryResolver;
import org.eclipse.thym.core.platform.AbstractProjectGeneratorDelegate;

public class WindowsPhoneProjectGenerator extends
		AbstractProjectGeneratorDelegate {

	@Override
	protected void generateNativeFiles(HybridMobileLibraryResolver resolver)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void replaceCordovaPlatformFiles(
			HybridMobileLibraryResolver resolver) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected File getPlatformWWWDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

}
