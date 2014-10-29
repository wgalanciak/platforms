package com.zend.thym.wp.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.thym.core.HybridCore;
import org.eclipse.thym.core.engine.HybridMobileLibraryResolver;

public class WPLibraryResolver extends HybridMobileLibraryResolver {

	@Override
	public URL getTemplateFile(IPath destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatus isLibraryConsistent() {
		if (version == null) {
			return new Status(
					IStatus.ERROR,
					HybridCore.PLUGIN_ID,
					"Library for iOS platform is not compatible with this tool. VERSION file is missing.");
		}
		return Status.CANCEL_STATUS;
	}

	@Override
	public void preCompile(IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean needsPreCompilation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String detectVersion() {
		File versionFile = this.libraryRoot.append("VERSION").toFile();
		if (versionFile.exists()) {
			BufferedReader reader = null;
			try {
				try {
					reader = new BufferedReader(new FileReader(versionFile));
					String version = reader.readLine();
					if (version != null) {
						return version.trim();
					}
				} finally {
					if (reader != null)
						reader.close();
				}
			} catch (IOException e) {
				WPCore.log(IStatus.ERROR, "Can not detect version on library",
						e);
			}
		} else {
			WPCore.log(IStatus.ERROR, NLS.bind(
					"Can not detect version. VERSION file {0} is missing",
					versionFile.toString()), null);
		}
		return null;
	}

}
