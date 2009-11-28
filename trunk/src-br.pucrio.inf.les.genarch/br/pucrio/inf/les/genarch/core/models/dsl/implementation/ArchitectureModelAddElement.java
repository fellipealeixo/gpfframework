package br.pucrio.inf.les.genarch.core.models.dsl.implementation;

import static br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureComponentBuilder.architectureComponent;
import static br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureFolderBuilder.architectureFolder;
import static br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureResourcesContainerBuilder.architectureResourcesContainer;
import static br.pucrio.inf.les.genarch.core.models.dsl.implementation.ArchitectureSourceContainerBuilder.architectureSourceContainer;
import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractComponentParentPath;
import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractContainerName;
import static br.pucrio.inf.les.genarch.core.util.PathProcessor.extractElementNameByPath;

import org.eclipse.core.runtime.Path;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;

public class ArchitectureModelAddElement {

	private ArchitectureModelHandle architectureModelHandle;

	public ArchitectureModelAddElement(
			ArchitectureModelHandle architectureModelHandle) {
		this.architectureModelHandle = architectureModelHandle;
	}

	public ArchitectureModelAddElement component(ArchitectureComponent architectureComponent) {
		Path iPath = new Path(architectureComponent.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2) {
			ArchitectureContainer container = architectureModelHandle.get()
					.sourceContainer(extractContainerName(architectureComponent.getPath()));

			if (container != null) {
				container.getComponents().add(architectureComponent);
			} else {
				this.architectureModelHandle
						.getArchitecture()
						.getContainers()
						.add(architectureSourceContainer().name(extractContainerName(architectureComponent.getPath())));
			}
		} else {
			ArchitectureComponent parent = architectureModelHandle.get()
					.component(
							extractComponentParentPath(architectureComponent
									.getPath()));

			if (parent == null) {
				parent = architectureComponent()
						.name(
								extractElementNameByPath(extractComponentParentPath(architectureComponent
										.getPath())))
						.path(
								extractComponentParentPath(architectureComponent
										.getPath())).build();
				component(parent);

			}

			parent.getSubComponents().add(architectureComponent);
		}
		return this;
	}

	public ArchitectureModelAddElement folder(ArchitectureFolder architectureFolder) {
		Path iPath = new Path(architectureFolder.getPath());
		int segmentCount = iPath.segmentCount();

		if (segmentCount == 2) {
			ArchitectureResourcesContainer container = architectureModelHandle
					.resourceContainer().get(
							extractContainerName(architectureFolder.getPath()));

			if (container != null) {
				container.getFolders().add(architectureFolder);
			} else {
				this.architectureModelHandle.getArchitecture()
						.getResourcesContainer().add(
								architectureResourcesContainer().name(
										extractContainerName(architectureFolder
												.getPath())));
			}
		} else {
			ArchitectureFolder parent = architectureModelHandle.get().folder(
					extractComponentParentPath(architectureFolder.getPath()));

			if (parent == null) {
				parent = architectureFolder()
						.name(
								extractElementNameByPath(extractComponentParentPath(architectureFolder
										.getPath()))).path(
								extractComponentParentPath(architectureFolder
										.getPath())).build();
				folder(parent);

			}

			parent.getSubFolders().add(architectureFolder);
		}
		return this;
	}

	public ArchitectureModelAddElement clazz(ArchitectureClass architectureClass) {
		if (architectureModelHandle.get().clazz(architectureClass.getPath()) == null) {
			ArchitectureComponent parent = architectureModelHandle.get()
					.component(
							extractComponentParentPath(architectureClass
									.getPath()));

			if (parent == null) {
				parent = architectureComponent()
						.name(
								extractElementNameByPath(extractComponentParentPath(architectureClass
										.getPath()))).path(
								extractComponentParentPath(architectureClass
										.getPath())).build();
				component(parent);
			}

			parent.getClasses().add(architectureClass);
		}
		return this;
	}

	public ArchitectureModelAddElement aspect(
			ArchitectureAspect architectureAspect) {
		if (architectureModelHandle.get().aspect(architectureAspect.getPath()) == null) {
			ArchitectureComponent parent = architectureModelHandle.get()
					.component(
							extractComponentParentPath(architectureAspect
									.getPath()));

			if (parent == null) {
				parent = architectureComponent()
						.name(
								extractElementNameByPath(extractComponentParentPath(architectureAspect
										.getPath()))).path(
								extractComponentParentPath(architectureAspect
										.getPath())).build();
				component(parent);
			}

			parent.getAspects().add(architectureAspect);
		}
		return this;
	}

	public ArchitectureModelAddElement file(ArchitectureFile architectureFile) {
		if (architectureModelHandle.get().file(architectureFile.getPath()) == null) {
			Path iPath = new Path(architectureFile.getPath());
			int segmentCount = iPath.segmentCount();

			if (segmentCount == 2) {
				ArchitectureResourcesContainer container = architectureModelHandle
						.resourceContainer()
						.get(extractContainerName(architectureFile.getPath()));

				if (container != null) {
					container.getFiles().add(architectureFile);
				} else {
					this.architectureModelHandle
							.getArchitecture()
							.getResourcesContainer()
							.add(
									architectureResourcesContainer()
											.name(
													extractContainerName(architectureFile
															.getPath())));
				}
			} else {
				ArchitectureContainer sourceContainer = architectureModelHandle
						.get()
						.sourceContainer(
								extractContainerName(architectureFile.getPath()));

				if (sourceContainer != null) {
					ArchitectureComponent parent = architectureModelHandle
							.get().component(
									extractComponentParentPath(architectureFile
											.getPath()));

					if (parent == null) {
						parent = architectureComponent()
								.name(
										extractElementNameByPath(extractComponentParentPath(architectureFile
												.getPath())))
								.path(
										extractComponentParentPath(architectureFile
												.getPath())).build();
						component(parent);
					}

					parent.getFiles().add(architectureFile);
				} else {
					ArchitectureResourcesContainer resourcesContainer = architectureModelHandle
							.resourceContainer().get(
									extractContainerName(architectureFile
											.getPath()));

					if (resourcesContainer != null) {
						ArchitectureFolder parent = architectureModelHandle
								.get()
								.folder(
										extractComponentParentPath(architectureFile
												.getPath()));

						if (parent == null) {
							parent = architectureFolder()
									.name(
											extractElementNameByPath(extractComponentParentPath(architectureFile
													.getPath())))
									.path(
											extractComponentParentPath(architectureFile
													.getPath())).build();
							folder(parent);

						}

						parent.getFiles().add(architectureFile);
					}
				}
			}
		}
		return this;
	}

	public ArchitectureModelAddElement template(ArchitectureTemplate architectureTemplate) {
		if ( architectureModelHandle.get().file(architectureTemplate.getPath()) == null ) {
			ArchitectureComponent parent = architectureModelHandle.get().component(extractComponentParentPath(architectureTemplate.getPath()));

			if ( parent == null ) {
				parent = architectureComponent().name(extractElementNameByPath(extractComponentParentPath(architectureTemplate.getPath())))
				.path(extractComponentParentPath(architectureTemplate.getPath())).build();
				component(parent);
			}

			parent.getTemplates().add(architectureTemplate);
		}
		return this;
	}}
