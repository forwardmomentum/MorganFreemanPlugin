package com.forwardmomentum.intellij.plugins.freeman;

import com.intellij.codeHighlighting.Pass;
import com.intellij.codeInsight.daemon.GutterIconNavigationHandler;
import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.List;

/**
 * Created by forwardmomentum on 11.05.17.
 */
public class FreemanPointMarkerProvider implements LineMarkerProvider {
//
//    @Override
//    protected void collectNavigationMarkers(@NotNull PsiElement element,
//                                            Collection<? super RelatedItemLineMarkerInfo> result) {
//        if (element instanceof PsiLiteralExpression) {
//            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
//            String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
//            if (value != null && value.startsWith("simple" + ":")) {
//                Project project = element.getProject();
//                final List<SimpleProperty> properties = SimpleUtil.findProperties(project, value.substring(7));
//                if (properties.size() > 0) {
//                    NavigationGutterIconBuilder<PsiElement> builder =
//                            NavigationGutterIconBuilder.create(SimpleIcons.FILE).
//                                    setTargets(properties).
//                                    setTooltipText("Navigate to a simple property");
//                    result.add(builder.createLineMarkerInfo(element));
//                }
//            }
//        }
//    }


    @Override
    public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement element) {
//        if (element instanceof PsiIdentifier && element.getParent() instanceof PsiMethod)
//        element.getContext().
            return new LineMarkerInfo<>(
                    element,
                    element.getTextRange(),
                    AllIcons.Vcs.Arrow_right,
                    Pass.LINE_MARKERS,
                    el -> "Execute me",
                    new GutterIconNavigationHandler<PsiElement>() {
                        @Override
                        public void navigate(MouseEvent e, PsiElement elt) {
                            if (elt.isValid()) {
                                System.out.println("OHHOHA");
//                                showPopup(e, elt, "Hah");
                            }
                        }
                    },
                    GutterIconRenderer.Alignment.RIGHT
            );
//        return null;
    }

    @Override
    public void collectSlowLineMarkers(@NotNull List<PsiElement> list, @NotNull Collection<LineMarkerInfo> collection) {
        int x = 7;

    }


//    private static void showPopup(@NotNull MouseEvent e, @NotNull final PsiElement psiElement, final String displayName) {
//        final JBList list = new JBList(getAvailableTypes());
//        list.setCellRenderer(new ListCellRendererWrapper<Type>() {
//            @Override
//            public void customize(JList list, Type value, int index, boolean selected, boolean hasFocus) {
//                setIcon(value.getIcon());
//                setText(value.getTitle(displayName));
//            }
//        });
//        PopupChooserBuilder builder = new PopupChooserBuilder(list);
//        JBPopup popup = builder.
//                setMovable(true).
//                setItemChoosenCallback(() -> {
//                    int[] ids = list.getSelectedIndices();
//                    if (ids.length == 0) return;
//                    Type type = ObjectUtils.tryCast(list.getSelectedValue(), Type.class);
//                    if (type != null) {
//                        if (psiElement.isValid()) {
//                            execute(type.getExecutor(), psiElement);
//                        }
//                    }
//                }).
//                createPopup();
//
//        popup.show(new RelativePoint(e));
//    }



}
